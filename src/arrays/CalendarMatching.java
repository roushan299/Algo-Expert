package arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class CalendarMatching {

    private static final String SEPARATOR = ":";

    static class StringMeeting{
        public String start;
        public String end;

        public StringMeeting(String start, String end) {
            this.start = start;
            this.end = end;
        }

        public boolean isStartSmall(StringMeeting meeting){
            int mins = convertIntoMins(this.start);
            int meetingMins  = convertIntoMins(meeting.start);
            return mins < meetingMins;
        }

        public boolean canBeMerged(StringMeeting meeting){
            int endMins =  convertIntoMins(this.end);
            int meetingStartMins =  convertIntoMins(meeting.start);
            return meetingStartMins <= endMins;
        }

        public String getMaxEndTime(StringMeeting meeting){
            int endMins =  convertIntoMins(this.end);
            int meetingEndMins =  convertIntoMins(meeting.end);

            if(meetingEndMins > endMins){
                return meeting.end;
            }else {
                return this.end;
            }

        }

        public int convertIntoMins(String time){
            int separatorIndex  = time.indexOf(SEPARATOR);
            int hour = Integer.parseInt(time.substring(0, separatorIndex));
            int minute = Integer.parseInt(time.substring(separatorIndex+1));
            return hour*60+minute;
        }

    }

    public static List<StringMeeting> calendarMatching(List<StringMeeting> calendar1, StringMeeting dailyBound1,
                                                       List<StringMeeting> calendar2, StringMeeting dailyBound2, int meetingDuration) {
        List<StringMeeting> meetingsOfUserOne = getMeetingsOfUser(calendar1, dailyBound1);
        List<StringMeeting> meetingsOfUserTwo = getMeetingsOfUser(calendar2, dailyBound2);
        List<StringMeeting> mergedUnavailableSlots = mergeInOnecalendar(meetingsOfUserOne, meetingsOfUserTwo);
        List<StringMeeting> unavailableSlots = mergeTheSlots(mergedUnavailableSlots);
        List<StringMeeting> availableSlots = getAvailableSlots(unavailableSlots, meetingDuration);
        return availableSlots;
    }

    private static List<StringMeeting> getMeetingsOfUser(List<StringMeeting> calendar, StringMeeting dailyBound) {
        List<StringMeeting> meetings = new ArrayList<>();
        StringMeeting startMeeting = getStartMeetingSlot(dailyBound);
        StringMeeting endMeeting = getEndMeetingSlot(dailyBound);

        meetings.add(startMeeting);
        meetings.addAll(calendar);
        meetings.add(endMeeting);
        return meetings;
    }

    private static StringMeeting getStartMeetingSlot(StringMeeting dailyBound) {
        StringMeeting meeting = new StringMeeting("0:00", dailyBound.start);
        return  meeting;
    }

    private static StringMeeting getEndMeetingSlot(StringMeeting dailyBound) {
        StringMeeting meeting = new StringMeeting(dailyBound.end, "23:59");
        return  meeting;
    }


    private static List<StringMeeting> mergeInOnecalendar(List<StringMeeting> meetingsOfUserOne, List<StringMeeting> meetingsOfUserTwo) {
        int index1 = 0;
        int index2 = 0;
        List<StringMeeting> mergedSlots = new ArrayList<>();

        while (index1 < meetingsOfUserOne.size() && index2 < meetingsOfUserTwo.size()) {

            if(meetingsOfUserOne.get(index1).isStartSmall(meetingsOfUserTwo.get(index2))) {
                mergedSlots.add(meetingsOfUserOne.get(index1));
                index1++;
            }else {
                mergedSlots.add(meetingsOfUserTwo.get(index2));
                index2++;
            }

        }
        copyAllMeetingSlotsFromIndex(index1, meetingsOfUserOne, mergedSlots);
        copyAllMeetingSlotsFromIndex(index2, meetingsOfUserTwo, mergedSlots);
        return mergedSlots;
    }

    private static void copyAllMeetingSlotsFromIndex(int index, List<StringMeeting> meetingsOfUser, List<StringMeeting> mergedSlots) {
        while(index < meetingsOfUser.size()) {
            mergedSlots.add(meetingsOfUser.get(index));
            index++;
        }
    }

    private static List<StringMeeting> mergeTheSlots(List<StringMeeting> calendar) {
        if(calendar.size() == 0) return calendar;
        Stack<StringMeeting> mergedSlots = new Stack<>();
        mergedSlots.push(calendar.get(0));

        int index = 1;

        while (index < calendar.size()) {
            StringMeeting prevMeeting = mergedSlots.peek();
            StringMeeting currentMeeting = calendar.get(index);

            if(prevMeeting.canBeMerged(currentMeeting)) {
                prevMeeting.end = prevMeeting.getMaxEndTime(currentMeeting);
            }else {
                mergedSlots.push(currentMeeting);
            }
            index++;
        }
        return new  ArrayList<>(mergedSlots);
    }

    private static List<StringMeeting> getAvailableSlots(List<StringMeeting> unavailableSlots, int meetingDuration) {
        List<StringMeeting> availableSlots = new ArrayList<>();

        for(int index = 1; index < unavailableSlots.size(); index++) {
            StringMeeting previous = unavailableSlots.get(index-1);
            StringMeeting current = unavailableSlots.get(index);

            int start = previous.convertIntoMins(previous.end);
            int end = current.convertIntoMins(current.start);

            if(end - start >= meetingDuration){
                availableSlots.add(new StringMeeting(previous.end, current.start));
            }
        }
        return availableSlots;
    }


}
