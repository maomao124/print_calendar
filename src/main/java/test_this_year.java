import java.util.Calendar;

/**
 * Project name(项目名称)：打印日历
 * Package(包名): PACKAGE_NAME
 * Class(类名): test_this_year
 * Author(作者）: mao
 * Author QQ：1296193245
 * Date(创建日期)： 2021/10/17
 * Time(创建时间)： 14:45
 * Version(版本): 1.0
 * Description(描述)： 打印今年的日历
 */

public class test_this_year
{
    public static void print_calendar(int year, int month)
    {
        Calendar calendar1 = Calendar.getInstance();
        calendar1.set(year, month - 1, 1);
        int index = calendar1.get(Calendar.DAY_OF_WEEK) - 1;
        char[] title = {'日', '一', '二', '三', '四', '五', '六'}; // 存放曰历的头部
        int[][] daysArray = new int[6][7];// 存放日历的数据
        int daysInMonth = 31; // 该月的天数
        int day1 = 1; // 自动增长
        for (int i = index; i < 7; i++)
        {
            // 填充第一周的日期数据，即日历中的第一行
            daysArray[0][i] = day1++;
        }
        for (int i = 1; i < 6; i++)
        {
            // 填充其他周的日历数据，控制行
            for (int j = 0; j < 7; j++)
            {
                // 如果当前day表示的是本月最后一天，则停止向数组中继续赋值
                if (day1 > daysInMonth)
                {
                    i = 6;
                    break;
                }
                daysArray[i][j] = day1++;
            }
        }
        System.out.println();
        for (char c : title)
        {
            System.out.print(c + "\t");
        }
        System.out.print("\n");
        // 输出二元数组daysArray中的元素
        for (int i = 0; i < 6; i++)
        {
            for (int j = 0; j < 7; j++)
            {
                if (daysArray[i][j] == 0)
                {
                    if (i != 0)
                    {
                        // 如果到月末，则完成显示日历的任务，停止该方法的执行
                        return;
                    }
                    System.out.print("\t");
                    continue;
                }
                System.out.print(daysArray[i][j] + "\t");
            }
            System.out.print("\n");
        }
    }

    public static void main(String... args)
    {
        Calendar c1 = Calendar.getInstance();
        int year = c1.get(Calendar.YEAR);
        System.out.println("打印今年的日历：");
        System.out.println();
        for (int i = 1; i <= 12; i++)
        {
            System.out.println();
            System.out.println(year + "年  " + i + "月：");
            print_calendar(year, i);
            System.out.println();
        }
    }
}
