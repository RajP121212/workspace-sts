package com.suraj.location.util;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.springframework.stereotype.Component;

//@Component tells spring that, this bean should be scanned
//And an instance of it should be generated at runtime
@Component
public class ReportUtilImpl implements IReportUtil {

	@Override
	public void generatePieChart(String path, List<Object[]> data) {

		DefaultPieDataset dataset = new DefaultPieDataset();

		for (Object[] objects : data) {
			dataset.setValue(objects[0].toString(), new Double(objects[1].toString()));
		}

		JFreeChart chart = ChartFactory.createPieChart3D("Location Type Report", dataset);
		
		try {
			ChartUtilities.saveChartAsJPEG(new File(path + "/pieChart.jpeg"), chart, 300, 300);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
