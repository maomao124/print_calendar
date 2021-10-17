import java.text.DecimalFormat;
import java.util.Calendar;

/**
 * Project name(项目名称)：打印日历
 * Package(包名): PACKAGE_NAME
 * Class(类名): test_this_month
 * Author(作者）: mao
 * Author QQ：1296193245
 * Date(创建日期)： 2021/10/17
 * Time(创建时间)： 14:44
 * Version(版本): 1.0
 * Description(描述)： 打印这个月的日历
 */

public class test_this_month
{
    public static void main(String... args)
    {
        System.out.println("打印这个月的日历:");
        System.out.println("现在时间：");
        Calendar calendar = Calendar.getInstance();// 获取当前时间
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        month = month + 1;                         //月份从 0 开始，所以加 1
        int day = calendar.get(Calendar.DATE);
        int week = calendar.get(Calendar.DAY_OF_WEEK);
        week = week - 1;                             //星期日为第一天
        int hour = calendar.get(Calendar.HOUR_OF_DAY); //时
        int minute = calendar.get(Calendar.MINUTE);   //分
        int second = calendar.get(Calendar.SECOND);   //秒
        int millisecond = calendar.get(Calendar.MILLISECOND); //毫秒
        int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH); // 获取今天是本月第几天
        int dayOfWeekInMonth = calendar.get(Calendar.DAY_OF_WEEK_IN_MONTH); // 获取今天是本月第几周
        int many = calendar.get(Calendar.DAY_OF_YEAR); // 获取今天是今年第几天
        StringBuffer stringBuffer1 = new StringBuffer();
        DecimalFormat decimalFormat1 = new DecimalFormat("00");
        //stringBuffer1.append(year).append("年 ").append(month).append("月 ").append(day).append("日 ")
        // .append(hour).append("时 ").append(minute).append("分 ").append(second).append("秒");
        stringBuffer1.append(decimalFormat1.format(year)).append("/").append(decimalFormat1.format(month)).append("/")
                .append(decimalFormat1.format(day)).append("    ").append(decimalFormat1.format(hour))
                .append(":").append(decimalFormat1.format(minute)).append(":").append(decimalFormat1.format(second));
        System.out.println(stringBuffer1);

        Calendar calendar1 = Calendar.getInstance();
        calendar1.set(year, month - 1, 1);
        int index = calendar1.get(Calendar.DAY_OF_WEEK) - 1;
        char[] title = {'日', '一', '二', '三', '四', '五', '六'}; // 存放曰历的头部
        int[][] daysArray = new int[6][7];// 存放日历的数据
        int[] daysInMonth;
        if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0))
        {
            daysInMonth = new int[]{31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}; // 该月的天数,闰年
            System.out.println("今年为闰年");
        }
        else
        {
            daysInMonth = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}; // 该月的天数
            System.out.println("今年为平年");
        }
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
                if (day1 > daysInMonth[month - 1])
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
}
