package cn.com.voge.gzvm.chart;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import ChartDirector.*;

public class GebileChart {
	public static String CHART_FONT = "微软雅黑";
	/**
	 * 创建一个空白图片
	 * 
	 * @param width
	 * @param height
	 * @return
	 */
	public static BaseChart getEmptyChart(int width, int height) {
		XYChart c = new XYChart(width, height, Chart.silverColor());
		configChart(c);
		return c;
	}

	/**
	 * 创建一个只有文字信息的图，主要用于图形生成错误时提示用户
	 * 
	 * @param width
	 * @param height
	 * @param title
	 * @return
	 */
	public static BaseChart getMessageChart(int width, int height, String title) {
		XYChart c = new XYChart(width, height, Chart.silverColor());
		configChart(c);
		if (title != null) {
			c.addText(width / 2, height / 2, title, CHART_FONT, 12, Chart.TextColor, Chart.Center);
		}
		return c;
	}

	/**
	 * 创建一个饼图
	 * 
	 * @param width
	 * @param height
	 * @param title
	 * @param labels
	 * @param datas
	 * @param is3D
	 * @return
	 */
	public static BaseChart getPieChart(int width, int height, String title, String[] labels, double[] datas,
			boolean is3D) {
		PieChart chart = new PieChart(width, height);
		configChart(chart);

		//chart.addTitle(title, "黑体", 13);
		chart.setData(datas, labels);

		if (is3D) {
			chart.setPieSize(width / 2, height / 2, Math.min(width / 2 - 30, height / 2 - 35));
			chart.set3D();
			chart.setExplode(0);
		} else {
			chart.setPieSize(width / 2, height / 2, Math.min(width / 2 - 30, height / 2 - 35));
			chart.setLabelPos(-40);
		}
		return chart;
	}

	/**
	 * 创建一个半圆的仪表盘
	 * 
	 * @param width
	 * @param height
	 * @param title
	 * @param value
	 * @param lowerValue
	 * @param upperValue
	 * @return
	 */
	public static BaseChart getSemiCircleMeterChart(int width, int height, String title, String valueContent,
			double value, double lowerValue, double upperValue) {
		AngularMeter m = new AngularMeter(width, height, Chart.silverColor());
		configChart(m);

		int radius = Math.min(250, Math.min(width / 2 - 50, height - 35));
		int xpos = width / 2;
		int ypos = height - 10 - (height - radius - 50) / 2;

		m.setMeter(xpos, ypos, radius, -90, 90);
		double upperLimit = upperValue * 1.5;
		double majorTickInc = (upperLimit - lowerValue) / 10;
		double minorTickInc = majorTickInc / 2;
		double microTickInc = minorTickInc / 2;

		m.setScale(lowerValue, upperLimit, majorTickInc, minorTickInc, microTickInc);

		double v75 = upperValue * 0.75;
		double v85 = upperValue * 0.85;
		double v120 = upperValue * 1.2;
		m.addZone(0, v75, 0, radius, 0xff6666); // red
		m.addZone(v75, v85, 0, radius, 0xffff33); // yellow
		m.addZone(v85, v120, 0, radius, 0x66ff66); // green
		m.addZone(v120, upperLimit, 0, radius, 0x0066ff); // blue

		m.addText(xpos, ypos - radius / 2, valueContent, CHART_FONT, 9, Chart.TextColor, Chart.Center);
		// m.addText(width - 70, 8, m.formatValue(value, "2"), "Arial", 9,
		// 0xffffff).setBackground(0x000000, 0, -1);
		m.addPointer(value, 0x40666699, 0x000000);

		m.setLabelFormat("{value|2,.}");
		return m;
	}

	/**
	 * 创建一个折线图
	 * 
	 * @param width
	 * @param height
	 * @param title
	 * @param yAxisTitle
	 * @param xAxisLabels
	 * @param barLabels
	 * @param barDatas
	 * @param is3D
	 * @return
	 */
	public static BaseChart getMultiLineChart(int width, int height, String title, String yAxisTitle,
			String[] xAxisLabels, String[] barLabels, double[][] barDatas, boolean is3D) {
		XYChart c = new XYChart(width, height, 0xeeeeff, 0x000000, 1);
		configChart(c);
		//c.addTitle(title, "黑体", 13);

		c.setPlotArea(80, 10, width - 100, height - 35, 0xffffff, -1, -1, 0xcccccc, 0xcccccc);
		c.addLegend(85, 3, false, CHART_FONT, 8).setBackground(Chart.Transparent);

		c.yAxis().setTitle(yAxisTitle);
		c.xAxis().setLabels(xAxisLabels);

		LineLayer layer = c.addLineLayer2();
		if (is3D) {
			layer.set3D();
		}
		layer.setLineWidth(2);

		for (int i = 0; i < barLabels.length; ++i) {
			layer.addDataSet(barDatas[i], -1, barLabels[i]);
		}
		return c;
	}

	/**
	 * 创建一个柱形图
	 * 
	 * @param width
	 * @param height
	 * @param title
	 * @param yAxisTitle
	 * @param xAxisLabels
	 * @param barLabels
	 * @param barDatas
	 * @param depth
	 * @return
	 */
	public static BaseChart getMultiBarChart(int width, int height, String title, String yAxisTitle,
			String[] xAxisLabels, String[] barLabels, double[][] barDatas, int depth) {
		XYChart chart = new XYChart(width, height);
		configChart(chart);
		int len = xAxisLabels.length;
		for(int i=0;i<len;i++){
			xAxisLabels[i]="<*font='" +CHART_FONT+"'*>"+xAxisLabels[i]+"<*/*>";
		}
		//chart.addTitle("<*font='" +CHART_FONT+"'*>"+title+"<*/*>", CHART_FONT, 13);
		chart.setPlotArea(70, 40, width - 90, height - 65, 0xffffff, 0xffffff);
		chart.addLegend(85, 10, false, CHART_FONT, 8).setBackground(Chart.Transparent);
		chart.yAxis().setTitle(yAxisTitle);
		chart.yAxis().setTopMargin(20);
		chart.xAxis().setLabels(xAxisLabels);
		BarLayer layer = chart.addBarLayer2(Chart.Side, depth);
		for (int i = 0; i < barLabels.length; ++i) {
			layer.addDataSet(barDatas[i], -1, barLabels[i]);
		}
		return chart;
	}
	
	public static BaseChart getMultiHStackedBarChart(int width, int height, String title, String yAxisTitle,
			String[] xAxisLabels, String[] barLabels, double[][] barDatas, int depth) {
		XYChart chart = new XYChart(width, height);
		configChart(chart);
		int len = xAxisLabels.length;
		for(int i=0;i<len;i++){
			xAxisLabels[i]="<*font='" +CHART_FONT+"' size=10*>"+xAxisLabels[i]+"<*/*>";
		}
		//chart.addTitle("<*font='" +CHART_FONT+"'*>"+title+"<*/*>", CHART_FONT, 13);
		chart.setPlotArea(70, 50, width - 90, height - 95, 0xffffff, 0xffffff);
		chart.addLegend(85, 10, false, CHART_FONT, 10).setBackground(Chart.Transparent);
		chart.yAxis().setTitle(yAxisTitle);
		chart.yAxis().setTopMargin(20);
		chart.xAxis().setLabels(xAxisLabels);
		BarLayer layer = chart.addBarLayer2(Chart.Stack, 10);
		for (int i = 0; i < barLabels.length; ++i) {
			layer.addDataSet(barDatas[i], -1, barLabels[i]);
		}
		layer.setAggregateLabelStyle();

        layer.setDataLabelStyle();
		return chart;
	}
	
	public static BaseChart getMultiVStackedBarChar(int width, int height, String title, String yAxisTitle,
			String[] xAxisLabels, String[] barLabels, double[][] barDatas, int depth){
		
	        // Create a XYChart object of size 600 x 350 pixels, using 0xe0e0ff as the
	        // background color, 0xccccff as the border color, with 1 pixel 3D border
	        // effect.
			int len = xAxisLabels.length;
			for(int i=0;i<len;i++){
				xAxisLabels[i]="<*font='" +CHART_FONT+"'*>"+xAxisLabels[i]+"<*/*>";
			}
	        XYChart c = new XYChart(width, height, 0xffffff, 0xccccff, 1);

	        // Add a title to the chart using 14 points Times Bold Itatic font and light
	        // blue (0x9999ff) as the background color
	       // c.addTitle(title, CHART_FONT, 13);

	        // Set the plotarea at (60, 45) and of size 500 x 210 pixels, using white
	        // (0xffffff) as the background
	        c.setPlotArea(50, 45, width - 90, height - 95, 0xffffff);

	        // Swap the x and y axes to create a horizontal bar chart
	        c.swapXY();

	        // Add a title to the y axis using 11 pt Times Bold Italic as font
	        c.yAxis().setTitle(yAxisTitle, CHART_FONT, 11);
	        // Set the labels on the x axis
	        c.xAxis().setLabels(xAxisLabels);
	        // Disable x-axis ticks by setting the tick length to 0
	        c.xAxis().setTickLength(0);

	        // Add a stacked bar layer to the chart
	        BarLayer layer = c.addBarLayer2(Chart.Stack);

	        // Add the first two data sets to the chart as a stacked bar group
	        layer.addDataGroup("");
	        for (int i = 0; i < barLabels.length; ++i) {
				layer.addDataSet(barDatas[i], -1, barLabels[i]);
			}
	        
	        // Set the sub-bar gap to 0, so there is no gap between stacked bars with a
	        // group
	        layer.setBarGap(0.2, 0);

	        // Set the bar border to transparent
	        layer.setBorderColor(Chart.Transparent);

	        // Set the aggregate label format
	        layer.setAggregateLabelFormat("{value}");

	        // Set the aggregate label font to 8 point Arial Bold Italic
	        layer.setAggregateLabelStyle(CHART_FONT, 10);

	        // Reverse 20% space at the right during auto-scaling to allow space for the
	        // aggregate bar labels
	        c.yAxis().setAutoScale(0.2);

	        // Add a legend box at (310, 300) using TopCenter alignment, with 2 column
	        // grid layout, and use 8 pts Arial Bold Italic as font
	        LegendBox legendBox = c.addLegend(c.getWidth()/2, 15,false, CHART_FONT, 10);
	        legendBox.setAlignment(Chart.TopCenter);

	        // Set the format of the text displayed in the legend box
	        legendBox.setText("{dataSetName}");

	        // Set the background and border of the legend box to transparent
	        legendBox.setBackground(Chart.Transparent, Chart.Transparent);
	        return c;
	}

	/**
	 * 将BaseChart按指定图形格式输出至某个输出流
	 * 
	 * @param out
	 * @param chart
	 * @param format
	 * @throws IOException
	 */
	public static void writeChart(OutputStream out, BaseChart chart, int format) throws IOException {
		byte[] images = chart.makeChart2(format);
		out.write(images);
	}

	/**
	 * 按指定的图形格式生成临时文件
	 * 
	 * @param chart
	 * @param format
	 * @return
	 * @throws IOException
	 */
	public static File makeImageFile(BaseChart chart, String format) throws IOException {
		File file = File.createTempFile("voge-chart", "." + format);
		file.deleteOnExit();
		chart.makeChart(file.getName());
		return file;
	}

	/**
	 * 配置创建BaseChart的本地化参数
	 * 
	 * @param chart
	 */
	private static void configChart(BaseChart chart) {
		chart.setDefaultFonts(CHART_FONT, CHART_FONT, CHART_FONT);
	}

	static {
		// ChartDirector License load.
		Chart.setLicenseCode("RDST-25U3-HSU4-ZT4V-75AC-0999");
	}
}