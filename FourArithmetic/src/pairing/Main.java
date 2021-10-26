package pairing;

import java.io.File;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    private static boolean setRange = false;
    private static boolean setNumber = false;
    private static boolean setExerciseFile = false;
    private static boolean setAnswerFile = false;
    private static String exerciseFile = "UserAnswers.txt";
    private static String answerFile = "Answers.txt";
    private static int number;
    private static int range = 2;

    public static void main(String[] args) {
        File file1 = new File("UserAnswers.txt");
        File file2 = new File("Answers.txt");
        File file3 = new File("Exercises.txt");
        try {
            for (int i = 0; i < args.length - 1; i++) {
                if (args[i].matches("-n")) {
                    int num = Integer.parseInt(args[++i]);
                    if (num >= 1) {
                        setNumber(num);
                        Main.setNumber = true;
                    }
                }

                if (args[i].matches("-r")) {
                    int range = Integer.parseInt(args[++i]);
                    if (range >= 1) {
                        setRange(range);
                        Main.setRange = true;
                    }
                }

                if (args[i].matches("-e")) {
                    Main.exerciseFile = args[++i];
                    Main.setExerciseFile = true;
                }

                if (args[i].matches("-a")) {
                    Main.answerFile = args[++i];
                    Main.setAnswerFile = true;
                }
            }
            if (setNumber && setRange) {
//                System.out.println("请输入正确参数！");
                for (int i = 0; i < Main.number; i++) {
                    Generation g = new Generation();
                    String ques = g.GenerateExp(Main.range);//随机生成表达式

                    Calculation c = new Calculation();
                    String ans = c.cal(c.toHouzhui(ques));//计算表达式结果

                    if (ans.contains("-")) { //处理结果是负数情况
                        i = i - 1;
                        continue;
                    }
                    QuestionSaving qs = new QuestionSaving();
                    qs.Write(ques);//将表达式写入文档
                    AnswerSaving as = new AnswerSaving();
                    as.Write(ans);//将结果写入答案文档
                }
                new QuestionSaving().Saving(file3);//将问题追加保存到Exercises.txt文件中
                new AnswerSaving().Saving(file2);//将答案追加保存到Answer.txt文件中
            } else if (setExerciseFile && setAnswerFile) {
                GradeCheck gradeCheck = new GradeCheck();//答案和做题文档对比，调用ResultCheck对象 生成grade.txt文件                   break;
                gradeCheck.GetGrade(file1, file2);
            } else {
                System.out.println("请输入正确参数！");
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
            System.out.println("数组越界异常！");
        } catch (NumberFormatException e) {
            e.printStackTrace();
            System.out.println("数据类型错误！");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void setRange(int range) {
        Main.range = range;
    }

    private static void setNumber(int num) {
        Main.number = num;
    }
}

