import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class JumpGame {

    public static void main(String[] args) {

        int[] inputArray = {5,9,3,2,1,0,2,3,3,1,0,0};
        System.out.println(canJump(inputArray));
    }

    public static boolean canJump(int[] inputArray) {

        List<Integer> numStack =  new ArrayList<>();
        int startIndex = 0, movingIndex = 0;


        while (true) {

            if (movingIndex < inputArray.length - 1) {
                numStack.add(inputArray[movingIndex]);
                movingIndex += inputArray[movingIndex];
            }

            if(movingIndex >= inputArray.length - 1 || inputArray[movingIndex] == 0) {
                int sum = numStack.stream().mapToInt(Integer::intValue).sum();

                if (sum == inputArray.length-1) {
                    return true;
                } else {
                    int lastInt = numStack.getLast();


                    movingIndex -= lastInt;
                    movingIndex += (lastInt - 1);

                    if(movingIndex == inputArray.length - 1) {
                        return true;
                    }

                    if (movingIndex < 0) {
                        break;
                    }

                    if (lastInt -1 == 0 && numStack.size() == 1) {
                        break;
                    } else {
                        if (numStack.size() > 1 && numStack.getFirst() > 1){
                            movingIndex = (numStack.getFirst() - 1);
                            numStack.clear();
                            numStack.add(movingIndex);
                            continue;
                        }

                    }
                    numStack.removeLast();
                    if ((lastInt - 1) > 0) {
                        numStack.add(lastInt - 1);
                    }
                }
            }
        }
        return false;
    }

}
