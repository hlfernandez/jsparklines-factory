package org.sing_group.jsparklines_factory.builders;

import javax.swing.JTable;

import org.sing_group.jsparklines_factory.builders.barchartrenderer.MaximumBarChartRendererBuilder;
import org.sing_group.jsparklines_factory.builders.barchartrenderer.MaximumColoredBarChartRendererBuilder;
import org.sing_group.jsparklines_factory.builders.barchartrenderer.MaximumMinimumBarChartRendererBuilder;
import org.sing_group.jsparklines_factory.builders.barchartrenderer.MaximumMinimumColoredBarChartRendererBuilder;
import org.sing_group.jsparklines_factory.builders.barchartrenderer.MaximumMinimumXYDataSignificanceBarChartRendererBuilder;
import org.sing_group.jsparklines_factory.builders.barchartrenderer.MaximumXYDataSignificanceBarChartRendererBuilder;

public class JSparklinesBarChartTableCellRendererBuilderFactory {
	
	public static MaximumBarChartRendererBuilder newMaximumBarChartRenderer(
		JTable table, int column
	) {
		return new MaximumBarChartRendererBuilder(table, column);
	}

	public static MaximumColoredBarChartRendererBuilder newMaximumColoredBarChartRenderer(
		JTable table, int column
	) {
		return new MaximumColoredBarChartRendererBuilder(table, column);
	}
	
	public static MaximumXYDataSignificanceBarChartRendererBuilder newMaximumXYDataSignificanceBarChartRenderer(
		JTable table, int column
	) {
		return new MaximumXYDataSignificanceBarChartRendererBuilder(table, column);
	}

	public static MaximumMinimumXYDataSignificanceBarChartRendererBuilder newMaximumMinimumXYDataSignificanceBarChartRenderer(
		JTable table, int column
	) {
		return new MaximumMinimumXYDataSignificanceBarChartRendererBuilder(table, column);
	}

	public static MaximumMinimumBarChartRendererBuilder newMaximumMinimumBarChartRenderer(
		JTable table, int column
	) {
		return new MaximumMinimumBarChartRendererBuilder(table, column);
	}

	public static MaximumMinimumColoredBarChartRendererBuilder newMaximumMinimumColoredBarChartRenderer(
		JTable table, int column
		) {
		return new MaximumMinimumColoredBarChartRendererBuilder(table, column);
	}	
}

