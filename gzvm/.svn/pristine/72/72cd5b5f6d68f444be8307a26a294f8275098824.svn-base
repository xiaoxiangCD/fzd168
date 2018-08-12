package cn.com.voge.gzvm.chart;

import java.util.*;
import ChartDirector.BaseChart;
//import ChartDirector.XYChart;

import com.voyageci.core.service.BaseService;

@SuppressWarnings({ "rawtypes", "unchecked" })
public class ChartService  extends BaseService {
	int defaultWidth = 480;
	int defalutHeight = 800;
	
	public BaseChart getThemeBarChart(Map result,String resultsName,String xName,String title,String yName,Integer width,Integer height,String[] itemNames,String[] countNames){
		if(result == null){
			return null;
		}
		List<Map> results = (List<Map>)result.get(resultsName);
		if(results == null){
			return null;
		}
		int len = results.size();
		int length = countNames.length;
		String[] barLabels = itemNames;//new String[]{"全拍","不全","未拍"};
		String[] xAxisLabels = new String[len];
		double[][] barDatas = new double[length][len];	
		
		for(int i=0;i<len;i++){
			Map record = results.get(i);
			xAxisLabels[i] = getStringValue(record,xName);
			for(int j=0;j<length;j++ ){
				barDatas[j][i]=getDoubleValue(record,countNames[j]);
			}
		}
		if((width == null) ||(width <=0)){
			width = this.getDefaultWidth();
		}
		
		if((height == null) ||(height <=0)){
			height = this.getDefalutHeight();
		}
		
		//如果超过5个以后就需要生成宽度大的图片
		if(width < height){
			/*if(width < height){
				Integer tmp = width;
				width = height;
				height = tmp;
			}*/
			return GebileChart.getMultiVStackedBarChar(width, height, title, yName, xAxisLabels, barLabels, barDatas, 3);
		}
		return GebileChart.getMultiHStackedBarChart(width, height, title, yName, xAxisLabels, barLabels, barDatas, 3);
		//return GebileChart.getMultiBarChart(width, height, title, yName, xAxisLabels, barLabels, barDatas, 3);
	}
	

	public int getDefaultWidth() {
		return defaultWidth;
	}

	public void setDefaultWidth(int defaultWidth) {
		this.defaultWidth = defaultWidth;
	}

	public int getDefalutHeight() {
		return defalutHeight;
	}

	public void setDefalutHeight(int defalutHeight) {
		this.defalutHeight = defalutHeight;
	}
	
	
}
