package C3_StacksAndQueues;

import java.util.EmptyStackException;

public class P1_ThreeInOne {

    /**> Stacks 1 & 2 are flexible in size with max. size of (TS * 2/3)
     * > Stack 3 has a fixed size of (TS * 1/3)
     */

    private static final int TOTAL_SIZE = 12;
    private static int[] stacks = new int[TOTAL_SIZE];
    private static int top1 = -1, top2 = TOTAL_SIZE * 2/3, top3 = TOTAL_SIZE;

    public static void main(String args[]){
        System.out.println("Empty Stacks:");
        printAllStacks();

        push(1, 1);
        push(11, 2);
        push(21, 3);
        push(2, 1);
        push(12, 2);
        push(22, 3);
        push(3, 1);
        push(13, 2);
        push(23, 3);
        push(4, 1);
        push(14, 2);
        push(24, 3);
        System.out.println("\nPushing 4 elements in each stack:");
        printAllStacks();

        pop(1);
        push(15, 2);
        System.out.println("\nPopping from Stack 1 & Pushing to Stack 2");
        printAllStacks();
    }

    private static void push(int x, int toStackNo){
        switch (toStackNo){
            case 1:{

                if(top1 + 1 == top2)
                    throw new StackOverflowError();
                else
                    stacks[++top1] = x;
                break;

            } case 2:{

                if(top2 - 1 == top1)
                    throw new StackOverflowError();
                else
                    stacks[--top2] = x;
                break;

            } case 3:{

                if(top3 == (TOTAL_SIZE * 2/3))
                    throw new StackOverflowError();
                else
                    stacks[--top3] = x;
                break;

            }
        }
    }

    private static void pop(int fromStackNo){
        switch (fromStackNo){
            case 1:{

                if(top1 == -1)
                    throw new EmptyStackException();
                else
                    top1--;
                break;

            } case 2:{

                if(top2 == (TOTAL_SIZE * 2/3))
                    throw new EmptyStackException();
                else
                    top2++;
                break;

            } case 3:{

                if(top3 == TOTAL_SIZE)
                    throw new EmptyStackException();
                else
                    top3++;
                break;

            }
        }
    }

    private static Integer peek(int fromStackNo){
        switch (fromStackNo){
            case 1:{

                if(top1 == -1)
                    throw new EmptyStackException();
                else
                    return stacks[top1];

            } case 2:{

                if(top2 == (TOTAL_SIZE * 2/3))
                    throw new EmptyStackException();
                else
                    return stacks[top2];

            } case 3:{

                if(top3 == TOTAL_SIZE)
                    throw new EmptyStackException();
                else
                    return stacks[top3];

            }
        }
        return null;
    }

    private static boolean isEmpty(int stackNo){
        switch (stackNo){
            case 1: return top1 == -1;
            case 2: return top2 == (TOTAL_SIZE * 2/3);
            case 3: return top3 == TOTAL_SIZE;
        }
        return true;
    }

    private static void printAllStacks(){
        for(int i=0 ; i<=top1 ; i++)
            System.out.print(stacks[i] + (i==top1 ? "" : "<-"));
        System.out.print("<-top1  |  top2->");
        for(int i=top2 ; i<TOTAL_SIZE * 2/3 ; i++)
            System.out.print(stacks[i] + (i==((TOTAL_SIZE * 2/3) - 1) ? "" : "->"));
        System.out.print("  |  top3->");
        for(int i=top3 ; i<TOTAL_SIZE ; i++)
            System.out.print(stacks[i] + (i==TOTAL_SIZE - 1 ? "" : "->"));
        System.out.println();
    }

}
