package org.sing_group.jsparklines_factory.demo;

import static org.sing_group.jsparklines_factory.demo.DemoUtils.setNimbusLookAndFeel;
import static org.sing_group.jsparklines_factory.demo.DemoUtils.showComponent;

import javax.swing.JComponent;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import org.sing_group.jsparklines_factory.JSparklinesBarChartTableCellRendererFactory;

import no.uib.jsparklines.renderers.JSparklinesBarChartTableCellRenderer;

public class JSparklinesBarChartTableCellRendererFactoryDemo {

	public static void main(String[] args) {
		setNimbusLookAndFeel();
		showComponent(new JScrollPane(getDemoTable()));
	}

	private static JComponent getDemoTable() {
		JTable table = new DemoTable();
		JSparklinesBarChartTableCellRenderer sparkLinesRenderer = 
			JSparklinesBarChartTableCellRendererFactory
				.createMaxValueBarChartRenderer(table, 0);
		sparkLinesRenderer.showNumberAndChart(true, 40);

		JSparklinesBarChartTableCellRenderer sparkLinesRenderer2 = 
			JSparklinesBarChartTableCellRendererFactory
				.createMaxValueBarChartRenderer(table, 1);
		sparkLinesRenderer2.showNumberAndChart(true, 40);

		JSparklinesBarChartTableCellRenderer sparkLinesRenderer3 = 
			JSparklinesBarChartTableCellRendererFactory
				.createMaxXYDataSignificanceBarChartRenderer(table, 2);
		sparkLinesRenderer3.showNumberAndChart(true, 40);

		JSparklinesBarChartTableCellRenderer sparkLinesRenderer4 = 
			JSparklinesBarChartTableCellRendererFactory
				.createMaxMinXYDataSignificanceBarChartRenderer(table, 3);
		sparkLinesRenderer4.showNumberAndChart(true, 40);
	
		JSparklinesBarChartTableCellRenderer sparkLinesRenderer5 = 
			JSparklinesBarChartTableCellRendererFactory
				.createMaxMinValuesBarChartRenderer(table, 4);
		sparkLinesRenderer5.showNumberAndChart(true, 40);
	
		JSparklinesBarChartTableCellRenderer sparkLinesRenderer6 = 
			JSparklinesBarChartTableCellRendererFactory
				.createMaxMinValuesColoredBarChartRenderer(table, 5);
		sparkLinesRenderer6.showNumberAndChart(true, 40);

		return table;
	}
}
