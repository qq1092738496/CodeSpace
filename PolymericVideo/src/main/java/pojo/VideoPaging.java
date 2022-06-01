package pojo;

import java.util.List;

/**
 * @description:
 * @author: Andy
 * @time: 2021/8/27 22:13
 */

public class VideoPaging {
    private Integer Current_Page; //当前页数
    private Integer Page_Size;  //页面大小，每页显示多少数据
    private Integer Data_Sum;   //数据共多少条
    private List<Video> Data_Actual; //查询到的数据
    private Integer Page_Sum; //共多少页


    public VideoPaging() {
    }

    public VideoPaging(Integer current_Page, Integer page_Size, Integer data_Sum, List<Video> data_Actual) {
        Current_Page = current_Page;
        Page_Size = page_Size;
        Data_Sum = data_Sum;
        Data_Actual = data_Actual;
        if (null != this.Page_Size && null != this.Data_Sum) {
            this.Page_Sum = Data_Sum % Page_Size == 0 ? Data_Sum / Page_Size : Data_Sum / Page_Size + 1;

        }
    }

    public int getPage_Sum() {
        if (null != this.Page_Size && null != this.Data_Sum) {
            this.Page_Sum = Data_Sum % Page_Size == 0 ? Data_Sum / Page_Size : Data_Sum / Page_Size + 1;
            return this.Page_Sum;
        }
        return 0;
    }

    public Integer getCurrent_Page() {
        return Current_Page;
    }

    public void setCurrent_Page(Integer current_Page) {
        Current_Page = current_Page;
    }

    public Integer getPage_Size() {
        return Page_Size;
    }

    public void setPage_Size(Integer page_Size) {
        Page_Size = page_Size;
    }

    public Integer getData_Sum() {
        return Data_Sum;
    }

    public void setData_Sum(Integer data_Sum) {
        Data_Sum = data_Sum;
    }

    public List<Video> getData_Actual() {
        return Data_Actual;
    }

    public void setData_Actual(List<Video> data_Actual) {
        Data_Actual = data_Actual;
    }

    @Override
    public String toString() {

        if (null != this.Page_Size && null != this.Data_Sum) {
            this.Page_Sum = Data_Sum % Page_Size == 0 ? Data_Sum / Page_Size : Data_Sum / Page_Size + 1;

        }
        return "VideoPaging{" +
                "Current_Page=" + Current_Page +
                ", Page_Size=" + Page_Size +
                ", Data_Sum=" + Data_Sum +
                ", Data_Actual=" + Data_Actual +
                ", Page_Sum=" + Page_Sum +
                '}';
    }
}
