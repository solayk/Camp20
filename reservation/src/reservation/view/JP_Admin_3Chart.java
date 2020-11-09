package reservation.view;

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
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.HorizontalAlignment;
import org.jfree.ui.TextAnchor;

import reservation.model.vo.Chart_Database;

public class JP_Admin_3Chart {
	
	public JFreeChart getChart() {
		
		//=====================================================
		/**
		 * 데이터설정
		 * 201109 원우
		 */
		DefaultCategoryDataset datasetMonth = new DefaultCategoryDataset();
		DefaultCategoryDataset datasetYear = new DefaultCategoryDataset();
		DefaultCategoryDataset datasetPeriodChoice = new DefaultCategoryDataset();
		DefaultCategoryDataset datasetMixMonth = new DefaultCategoryDataset();
		DefaultCategoryDataset datasetMixYear = new DefaultCategoryDataset();
		DefaultCategoryDataset datasetMixPeriodChoice = new DefaultCategoryDataset();
		
		
		
		//=====================================================
		//=====================================================
		/**
		 * 데이터입력
		 * 201109 원우
		 */
		Chart_Database db = new Chart_Database();
		ArrayList<ArrayList> data = db.getData();
		
		// 1) 월
		// if
		for(ArrayList temp : data) {
			int value = (Integer)temp.get(0);
			String cate = (String)temp.get(1);
			datasetMonth.addValue(value, "월별", cate);
			
		}
		
		
		
		//=====================================================
		/**
		 * 렌더링 생성 / 옵션정의 / 렌더링 세팅
		 * 201109 원우
		 */
		// 렌더링 생성
		final BarRenderer renderer = new BarRenderer();
		
		
		// 옵션 정의
		final CategoryItemLabelGenerator generator = new StandardCategoryItemLabelGenerator();
		final ItemLabelPosition p_center = new ItemLabelPosition(ItemLabelAnchor.CENTER, TextAnchor.CENTER);
		final ItemLabelPosition p_below = new ItemLabelPosition(ItemLabelAnchor.OUTSIDE6, TextAnchor.TOP_LEFT);
		
		Font f = new Font("완도희망체", Font.BOLD, 14);
		Font axisF = new Font("완도희망체",Font.ITALIC, 14);
		
		
		// 렌더링 세팅
		// 그래프1
        renderer.setBaseItemLabelGenerator(generator);
        renderer.setBaseItemLabelsVisible(true);
        renderer.setBasePositiveItemLabelPosition(p_center);
        renderer.setBaseItemLabelFont(f);
        renderer.setSeriesPaint(0, new Color(0,162,255));
        
        
        
        /**
         * plot 생성 / plot에 데이터 적재 / 렌더링 순서 정의
         * 201109 원우
         */
        // plot 생성
        final CategoryPlot plot = new CategoryPlot();
        
        
        // plot에 데이터 적재
        plot.setDataset(datasetMonth);
        
        
        // plot 기본 설정
        plot.setOrientation(PlotOrientation.VERTICAL);
        plot.setRangeGridlinesVisible(true);
        plot.setDomainGridlinesVisible(true);
        
		
        // 렌더링 순서 정의
        plot.setDatasetRenderingOrder(DatasetRenderingOrder.FORWARD);
        
        
        
        /**
         * X축 / Y축
         * 201109 원우
         */
        // X축
        plot.setDomainAxis(new CategoryAxis());
        plot.getDomainAxis().setTickLabelFont(axisF);
        plot.getDomainAxis().setCategoryLabelPositions(CategoryLabelPositions.STANDARD);
        
        
        // Y축
        plot.setRangeAxis(new NumberAxis());
        plot.getRangeAxis().setTickLabelFont(axisF);
        
        
        
        /**
         * chart 생성
         * 201109 원우
         */
        final JFreeChart chart = new JFreeChart(plot);
        // 타이틀
        chart.setTitle("월별 매출");
        
        // 서브타이틀
        TextTitle copyright = new TextTitle("JFreeChart WaferMapPlot", new Font("SansSerif", Font.PLAIN, 9));
        copyright.setHorizontalAlignment(HorizontalAlignment.CENTER);
        chart.addSubtitle(copyright);
        return chart;
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
