package org.sing_group.jsparklines_factory.builders.barchartrenderer;

import static org.sing_group.jsparklines_factory.JSparklinesBarChartTableCellRendererFactory.DEFAULT_ORIENTATION;
import static org.sing_group.jsparklines_factory.JSparklinesBarChartTableCellRendererFactory.DEFAULT_POSITIVES_COLOR_LARGE_NUMBERS;
import static org.sing_group.jsparklines_factory.JSparklinesBarChartTableCellRendererFactory.createMaxValueColoredBarChartRenderer;

import java.awt.Color;

import javax.swing.JTable;

import org.jfree.chart.plot.PlotOrientation;
import org.sing_group.jsparklines_factory.util.TableUtils;

import no.uib.jsparklines.renderers.JSparklinesBarChartTableCellRenderer;

public class MaximumColoredBarChartRendererBuilder {

	private JTable table;
	private int column;
	private PlotOrientation plotOrientation = DEFAULT_ORIENTATION;
	private Double maxValue;
	private Color positiveValuesColor = DEFAULT_POSITIVES_COLOR_LARGE_NUMBERS;

	public MaximumColoredBarChartRendererBuilder(JTable table, int column) {
		this.table = table;
		this.column = column;
	}

	public MaximumColoredBarChartRendererBuilder withPlotOrientation(
		PlotOrientation plotOrientation
	) {
		this.plotOrientation = plotOrientation;
		return this;
	}

	public MaximumColoredBarChartRendererBuilder withMaxValue(
		Double maxValue
	) {
		this.maxValue = maxValue;
		return this;
	}
	
	public MaximumColoredBarChartRendererBuilder withPositiveValuesColor(
		Color positiveValuesColor 
	) {
		this.positiveValuesColor = positiveValuesColor;
		return this;
	}

	public JSparklinesBarChartTableCellRenderer build() {
		checkMaxValue();

		return createMaxValueColoredBarChartRenderer(table,
			column, plotOrientation, maxValue, positiveValuesColor);
	}

	private void checkMaxValue() {
		if (this.maxValue == null) {
			this.maxValue = TableUtils.getMaxColumnValue(table, column);
		}
	}
}
