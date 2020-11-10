package reservation.view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.labels.CategoryItemLabelGenerator;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.DatasetRenderingOrder;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.HorizontalAlignment;
import org.jfree.ui.TextAnchor;

import reservation.model.vo.Chart_Database;

public class JP_Admin_3Chart {

	// ========================================================================
	/**
	 * 월 매출
	 * 201110 원우
	 */
	public JFreeChart getMonthRevenueChart() {

		// 데이터설정
		DefaultCategoryDataset monRevenue_dataset = new DefaultCategoryDataset();


		// 데이터입력
		Chart_Database db = new Chart_Database();
		ArrayList<ArrayList> data = db.getMonRevData();

		for(ArrayList temp : data) {
			String cate = (String)temp.get(0);
			int value = (int)temp.get(1);
			monRevenue_dataset.addValue(value, "월별매출", cate);

		}


		// 렌더링 생성 / 옵션정의 / 렌더링 세팅
		// 렌더링 생성
		final LineAndShapeRenderer monRevenue_rendere = new LineAndShapeRenderer();


		// 옵션 정의
		final CategoryItemLabelGenerator generator = new StandardCategoryItemLabelGenerator();
		final ItemLabelPosition p_center = new ItemLabelPosition(ItemLabelAnchor.CENTER, TextAnchor.CENTER);
		final ItemLabelPosition p_below = new ItemLabelPosition(ItemLabelAnchor.OUTSIDE6, TextAnchor.TOP_LEFT);

		Font f = new Font("완도희망체", Font.BOLD, 14);
		Font axisF = new Font("완도희망체",Font.ITALIC, 14);


		// 렌더링 세팅
		// 그래프1 _월별매출
		monRevenue_rendere.setBaseItemLabelGenerator(generator);
		monRevenue_rendere.setBaseItemLabelsVisible(true);
		monRevenue_rendere.setBasePositiveItemLabelPosition(p_center);
		monRevenue_rendere.setBaseItemLabelFont(f);
		monRevenue_rendere.setSeriesPaint(0, new Color(0,162,255));


		// plot 생성 / plot에 데이터 적재 / 렌더링 순서 정의
		// plot 생성
		final CategoryPlot plot = new CategoryPlot();


		// plot에 데이터 적재
		plot.setDataset(monRevenue_dataset);
		plot.setRenderer(monRevenue_rendere);


		// plot 기본 설정
		plot.setOrientation(PlotOrientation.VERTICAL);
		plot.setRangeGridlinesVisible(true);
		plot.setDomainGridlinesVisible(true);


		// 렌더링 순서 정의
		plot.setDatasetRenderingOrder(DatasetRenderingOrder.FORWARD);


		// X축 / Y축
		// X축
		plot.setDomainAxis(new CategoryAxis());
		plot.getDomainAxis().setTickLabelFont(axisF);
		plot.getDomainAxis().setCategoryLabelPositions(CategoryLabelPositions.STANDARD);


		// Y축
		plot.setRangeAxis(new NumberAxis());
		plot.getRangeAxis().setTickLabelFont(axisF);


		// chart 생성
		final JFreeChart chart = new JFreeChart(plot);


		// 타이틀
		chart.setTitle("월별 매출");


		// 서브타이틀
		TextTitle copyright = new TextTitle("JFreeChart WaferMapPlot", new Font("SansSerif", Font.PLAIN, 9));
		copyright.setHorizontalAlignment(HorizontalAlignment.CENTER);
		chart.addSubtitle(copyright);
		return chart;


	}

	

	// ========================================================================
	/**
	 * 월 예약건
	 * 201110 원우
	 */
	public JFreeChart getMonthReservCountChart() {

		// 데이터설정
		DefaultCategoryDataset monReservCount_dataset = new DefaultCategoryDataset();

		// 데이터입력
		Chart_Database db = new Chart_Database();
		ArrayList<ArrayList> data = db.getMonReservData();

		for(ArrayList temp : data) {
			String cate = (String)temp.get(0);
			int value = (int)temp.get(1);
			monReservCount_dataset.addValue(value, "월별예약건", cate); 
		}

		// 렌더링 생성 / 옵션정의 / 렌더링 세팅
		// 렌더링 생성
		final BarRenderer monReserveCount_rendere = new BarRenderer();

		// 옵션 정의
		final CategoryItemLabelGenerator generator = new StandardCategoryItemLabelGenerator();
		final ItemLabelPosition p_center = new ItemLabelPosition(ItemLabelAnchor.CENTER, TextAnchor.CENTER);
		final ItemLabelPosition p_below = new ItemLabelPosition(ItemLabelAnchor.OUTSIDE6, TextAnchor.TOP_LEFT);

		Font f = new Font("완도희망체", Font.BOLD, 14);
		Font axisF = new Font("완도희망체",Font.ITALIC, 14);


		// 렌더링 세팅
		// 그래프2 _월별예약
		monReserveCount_rendere.setBaseItemLabelGenerator(generator);
		monReserveCount_rendere.setBaseItemLabelsVisible(true);
		monReserveCount_rendere.setBaseFillPaint(Color.WHITE);
		monReserveCount_rendere.setBaseItemLabelFont(f);
		monReserveCount_rendere.setBasePositiveItemLabelPosition(p_below);
		monReserveCount_rendere.setSeriesPaint(0,new Color(219,121,22));
		monReserveCount_rendere.setSeriesStroke(0,new BasicStroke(2.0f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND, 3.0f));

		final CategoryPlot plot = new CategoryPlot();

		plot.setDataset(monReservCount_dataset);
		plot.setRenderer(monReserveCount_rendere);

		plot.setOrientation(PlotOrientation.VERTICAL);
		plot.setRangeGridlinesVisible(true);
		plot.setDomainGridlinesVisible(true);

		// 렌더링 순서 정의
		plot.setDatasetRenderingOrder(DatasetRenderingOrder.FORWARD);


		// X축 / Y축
		// X축
		plot.setDomainAxis(new CategoryAxis());
		plot.getDomainAxis().setTickLabelFont(axisF);
		plot.getDomainAxis().setCategoryLabelPositions(CategoryLabelPositions.STANDARD);


		// Y축
		plot.setRangeAxis(new NumberAxis());
		plot.getRangeAxis().setTickLabelFont(axisF);


		// chart 생성
		final JFreeChart chart = new JFreeChart(plot);

		
		// 타이틀
		chart.setTitle("월별 예약");

		
		// 서브타이틀
		TextTitle copyright = new TextTitle("JFreeChart WaferMapPlot", new Font("SansSerif", Font.PLAIN, 9));
		copyright.setHorizontalAlignment(HorizontalAlignment.CENTER);
		chart.addSubtitle(copyright);
		return chart;



	}
	
    public JFreeChart getYearRevenueChart() {

        // 데이터설정
        DefaultCategoryDataset yeaerRevenue_dataset = new DefaultCategoryDataset();


        // 데이터입력
        Chart_Database db = new Chart_Database();
        ArrayList<ArrayList> data = db.getYearRevData();

        for(ArrayList temp : data) {
           String cate = (String)temp.get(0);
           int value = (int)temp.get(1);
           yeaerRevenue_dataset.addValue(value, "연간매출", cate);

        }


        // 렌더링 생성 / 옵션정의 / 렌더링 세팅
        // 렌더링 생성
        final LineAndShapeRenderer yearRevenue_rendere = new LineAndShapeRenderer();


        // 옵션 정의
        final CategoryItemLabelGenerator generator = new StandardCategoryItemLabelGenerator();
        final ItemLabelPosition p_center = new ItemLabelPosition(ItemLabelAnchor.CENTER, TextAnchor.CENTER);
        final ItemLabelPosition p_below = new ItemLabelPosition(ItemLabelAnchor.OUTSIDE6, TextAnchor.TOP_LEFT);

        Font f = new Font("완도희망체", Font.BOLD, 14);
        Font axisF = new Font("완도희망체",Font.ITALIC, 14);


        // 렌더링 세팅
        // 그래프1 _월별매출
        yearRevenue_rendere.setBaseItemLabelGenerator(generator);
        yearRevenue_rendere.setBaseItemLabelsVisible(true);
        yearRevenue_rendere.setBasePositiveItemLabelPosition(p_center);
        yearRevenue_rendere.setBaseItemLabelFont(f);
        yearRevenue_rendere.setSeriesPaint(0, new Color(0,162,255));


        // plot 생성 / plot에 데이터 적재 / 렌더링 순서 정의
        // plot 생성
        final CategoryPlot plot = new CategoryPlot();


        // plot에 데이터 적재
        plot.setDataset(yeaerRevenue_dataset);
        plot.setRenderer(yearRevenue_rendere);


        // plot 기본 설정
        plot.setOrientation(PlotOrientation.VERTICAL);
        plot.setRangeGridlinesVisible(true);
        plot.setDomainGridlinesVisible(true);


        // 렌더링 순서 정의
        plot.setDatasetRenderingOrder(DatasetRenderingOrder.FORWARD);


        // X축 / Y축
        // X축
        plot.setDomainAxis(new CategoryAxis());
        plot.getDomainAxis().setTickLabelFont(axisF);
        plot.getDomainAxis().setCategoryLabelPositions(CategoryLabelPositions.STANDARD);


        // Y축
        plot.setRangeAxis(new NumberAxis());
        plot.getRangeAxis().setTickLabelFont(axisF);


        // chart 생성
        final JFreeChart chart = new JFreeChart(plot);


        // 타이틀
        chart.setTitle("연간 매출");


        // 서브타이틀
        TextTitle copyright = new TextTitle("JFreeChart WaferMapPlot", new Font("SansSerif", Font.PLAIN, 9));
        copyright.setHorizontalAlignment(HorizontalAlignment.CENTER);
        chart.addSubtitle(copyright);
        return chart;


    }
    
    public JFreeChart getYearReservCountChart() {

        // 데이터설정
        DefaultCategoryDataset yearReservCount_dataset = new DefaultCategoryDataset();


        // 데이터입력
        Chart_Database db = new Chart_Database();
        ArrayList<ArrayList> data = db.getYearReservData();

        for(ArrayList temp : data) {
           String cate = (String)temp.get(0);
           int value = (int)temp.get(1);
           yearReservCount_dataset.addValue(value, "연간예약건", cate); 
        }


        // 렌더링 생성 / 옵션정의 / 렌더링 세팅
        // 렌더링 생성
        final BarRenderer yearReserveCount_rendere = new BarRenderer();


        // 옵션 정의
        final CategoryItemLabelGenerator generator = new StandardCategoryItemLabelGenerator();
        final ItemLabelPosition p_center = new ItemLabelPosition(ItemLabelAnchor.CENTER, TextAnchor.CENTER);
        final ItemLabelPosition p_below = new ItemLabelPosition(ItemLabelAnchor.OUTSIDE6, TextAnchor.TOP_LEFT);

        Font f = new Font("완도희망체", Font.BOLD, 14);
        Font axisF = new Font("완도희망체",Font.ITALIC, 14);


        // 렌더링 세팅
        // 그래프2 _월별예약
        yearReserveCount_rendere.setBaseItemLabelGenerator(generator);
        yearReserveCount_rendere.setBaseItemLabelsVisible(true);



        yearReserveCount_rendere.setBaseFillPaint(Color.WHITE);
        yearReserveCount_rendere.setBaseItemLabelFont(f);
        yearReserveCount_rendere.setBasePositiveItemLabelPosition(p_below);
        yearReserveCount_rendere.setSeriesPaint(0,new Color(219,121,22));
        yearReserveCount_rendere.setSeriesStroke(0,new BasicStroke(2.0f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND, 3.0f));


        // plot 생성 / plot에 데이터 적재 / 렌더링 순서 정의
        // plot 생성
        final CategoryPlot plot = new CategoryPlot();



        // plot에 데이터 적재
        plot.setDataset(yearReservCount_dataset);
        plot.setRenderer(yearReserveCount_rendere);


        // plot 기본 설정
        plot.setOrientation(PlotOrientation.VERTICAL);
        plot.setRangeGridlinesVisible(true);
        plot.setDomainGridlinesVisible(true);


        // 렌더링 순서 정의
        plot.setDatasetRenderingOrder(DatasetRenderingOrder.FORWARD);


        // X축 / Y축
        // X축
        plot.setDomainAxis(new CategoryAxis());
        plot.getDomainAxis().setTickLabelFont(axisF);
        plot.getDomainAxis().setCategoryLabelPositions(CategoryLabelPositions.STANDARD);


        // Y축
        plot.setRangeAxis(new NumberAxis());
        plot.getRangeAxis().setTickLabelFont(axisF);


        // chart 생성
        final JFreeChart chart = new JFreeChart(plot);

        
        // 타이틀
        chart.setTitle("연간 예약");

        
        // 서브타이틀
        TextTitle copyright = new TextTitle("JFreeChart WaferMapPlot", new Font("SansSerif", Font.PLAIN, 9));
        copyright.setHorizontalAlignment(HorizontalAlignment.CENTER);
        chart.addSubtitle(copyright);
        return chart;
        
    }
    
    

}




