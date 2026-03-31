package recursion;

import java.util.ArrayList;
import java.util.List;

public class LowestCommonManager {

    static class OrgChart{
        public char name;
        public List<OrgChart> directReports;

        OrgChart(char name){
            this.name = name;
            this.directReports = new ArrayList<OrgChart>();
        }

        public void addDirectReport(OrgChart[] directReports){

            for (OrgChart directReport : directReports){
                this.directReports.add(directReport);
            }
        }

    }

    static class OrgInfo{
        public OrgChart lowestCommonManager;
        public int numImportantReport;

        OrgInfo(OrgChart lowestCommonManager, int numImportantReport){
            this.lowestCommonManager = lowestCommonManager;
            this.numImportantReport = numImportantReport;
        }
    }

    public static OrgChart getLowestCommonManager(OrgChart topManager, OrgChart reportOne, OrgChart reportTwo){
        return getOrgInfo(topManager, reportOne, reportTwo).lowestCommonManager;
    }

    private static OrgInfo getOrgInfo(OrgChart manager, OrgChart reportOne, OrgChart reportTwo) {
        int numImportantReport = 0;

        for(OrgChart directReport : manager.directReports){
            OrgInfo orgInfo = getOrgInfo(directReport, reportOne, reportTwo);

            if(orgInfo.lowestCommonManager != null) return orgInfo;
            numImportantReport += orgInfo.numImportantReport;
        }

        if(manager == reportOne || manager == reportTwo) numImportantReport += 1;
        OrgChart lowestCommonManager = numImportantReport == 2 ? manager : null;
        OrgInfo orgInfo = new OrgInfo(lowestCommonManager, numImportantReport);
        return orgInfo;
    }
}
