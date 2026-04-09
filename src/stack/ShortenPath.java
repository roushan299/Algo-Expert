package stack;

import javax.lang.model.element.NestingKind;
import java.util.*;
import java.util.stream.Collectors;

public class ShortenPath {

    private static final String BACK_TO_PARENT = "..";

    private static final String BACK_TO_CHILD = ".";

    private static final String PATH_SEPARATOR = "/";
    private static final String BLANK_PATH = "";


    public static String shortenPath(String path) {
        if(path.isEmpty() || path.isBlank()) return BLANK_PATH;

        boolean startsWithSlash = path.startsWith(PATH_SEPARATOR);
        Stack<String> stack = new Stack<>();
        String[] tokens = path.split(PATH_SEPARATOR);

        for(String token : tokens) {

            if(token.isEmpty() || token.equals(BACK_TO_CHILD)){
                continue;
            } else if (token.equals(BACK_TO_PARENT)) {

                if(!stack.isEmpty() && !stack.peek().equals(BACK_TO_PARENT)){
                    // we can pop when path is absolute
                    stack.pop();
                }else if(!startsWithSlash){
                    // we can't pop because path is relative we need to preserve the path with /../
                    stack.push(token);
                }
            }else {
                stack.push(token);
            }

        }
        StringBuilder shortestPath = new StringBuilder();

        if(startsWithSlash){
            shortestPath.append(PATH_SEPARATOR);
        }

        shortestPath.append(String.join(PATH_SEPARATOR, stack));
        return  shortestPath.length() == 0 ? ( startsWithSlash ? PATH_SEPARATOR : BLANK_PATH ) : shortestPath.toString();
    }

}
