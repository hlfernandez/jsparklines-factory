package org.sing_group.jsparklines_factory.demo;

import static org.sing_group.jsparklines_factory.demo.DemoUtils.setNimbusLookAndFeel;
import static org.sing_group.jsparklines_factory.demo.DemoUtils.showComponent;

import javax.swing.JComponent;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import org.sing_group.jsparklines_factory.builders.JSparklinesBarChartTableCellRendererBuilderFactory;

import no.uib.jsparklines.renderers.JSparklinesBarChartTableCellRenderer;

public class JSparklinesBarChartTableCellRendererBuilderDemo {

	public static void main(String[] args) {
		setNimbusLookAndFeel();
		showComponent(new JScrollPane(getDemoTable()));
	}

	private static JComponent getDemoTable() {
		JTable table = new DemoTable();
		
		JSparklinesBarChartTableCellRenderer sparkLinesRenderer = 
			JSparklinesBarChartTableCellRendererBuilderFactory
				.newMaximumBarChartRenderer(table, 0)
			.build();
		sparkLinesRenderer.showNumberAndChart(true, 40);
		
		JSparklinesBarChartTableCellRenderer sparkLinesRenderer2 = 
			JSparklinesBarChartTableCellRendererBuilderFactory
				.newMaximumColoredBarChartRenderer(table, 1)
			.build();
		sparkLinesRenderer2.showNumberAndChart(true, 40);
		
		JSparklinesBarChartTableCellRenderer sparkLinesRenderer3 = 
			JSparklinesBarChartTableCellRendererBuilderFactory
				.newMaximumXYDataSignificanceBarChartRenderer(table, 2)
			.build();
		sparkLinesRenderer3.showNumberAndChart(true, 40);

		JSparklinesBarChartTableCellRenderer sparkLinesRenderer4 = 
			JSparklinesBarChartTableCellRendererBuilderFactory
				.newMaximumMinimumXYDataSignificanceBarChartRenderer(table, 3)
			.build();
		sparkLinesRenderer4.showNumberAndChart(true, 40);

		JSparklinesBarChartTableCellRenderer sparkLinesRenderer5 = 
			JSparklinesBarChartTableCellRendererBuilderFactory
				.newMaximumMinimumBarChartRenderer(table, 4)
			.build();
		sparkLinesRenderer5.showNumberAndChart(true, 40);

		JSparklinesBarChartTableCellRenderer sparkLinesRenderer6 = 
			JSparklinesBarChartTableCellRendererBuilderFactory
				.newMaximumMinimumColoredBarChartRenderer(table, 5)
			.build();
		sparkLinesRenderer6.showNumberAndChart(true, 40);

		return table;
	}
}
