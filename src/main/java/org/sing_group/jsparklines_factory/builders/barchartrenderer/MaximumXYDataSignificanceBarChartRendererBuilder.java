package org.sing_group.jsparklines_factory.builders.barchartrenderer;

import java.awt.Color;

import javax.swing.JTable;

import org.jfree.chart.plot.PlotOrientation;
import org.sing_group.jsparklines_factory.JSparklinesBarChartTableCellRendererFactory;
import org.sing_group.jsparklines_factory.util.TableUtils;

import no.uib.jsparklines.renderers.JSparklinesBarChartTableCellRenderer;

public class MaximumXYDataSignificanceBarChartRendererBuilder {

	private JTable table;
	private int column;
	private PlotOrientation plotOrientation = JSparklinesBarChartTableCellRendererFactory.DEFAULT_ORIENTATION;
	private Double maxValue;
	private Color positiveValuesColor = JSparklinesBarChartTableCellRendererFactory.DEFAULT_POSITIVES_COLOR;
	private Color nonSignificantValuesColor = JSparklinesBarChartTableCellRendererFactory.DEFAULT_NON_SIGNIFICANT_COLOR;
	private Double significanceLevel = JSparklinesBarChartTableCellRendererFactory.DEFAULT_SIGNIFICANCE_LEVEL;

	public MaximumXYDataSignificanceBarChartRendererBuilder(JTable table, int column) {
		this.table = table;
		this.column = column;
	}

	public MaximumXYDataSignificanceBarChartRendererBuilder withPlotOrientation(
		PlotOrientation plotOrientation
	) {
		this.plotOrientation = plotOrientation;
		return this;
	}

	public MaximumXYDataSignificanceBarChartRendererBuilder withMaxValue(
		Double maxValue
	) {
		this.maxValue = maxValue;
		return this;
	}

	public MaximumXYDataSignificanceBarChartRendererBuilder withPositiveValuesColor(
		Color positiveValuesColor
	) {
		this.positiveValuesColor = positiveValuesColor;
		return this;
	}

	public MaximumXYDataSignificanceBarChartRendererBuilder withNonSignificanteValuesColor(
		Color nonSignificantValuesColor
	) {
		this.nonSignificantValuesColor = nonSignificantValuesColor;
		return this;
	}

	public MaximumXYDataSignificanceBarChartRendererBuilder withSignificanceLevel(
		Double significanceLevel
	) {
		this.significanceLevel = significanceLevel;
		return this;
	}

	public JSparklinesBarChartTableCellRenderer build() {
		checkMaxValue();

		return JSparklinesBarChartTableCellRendererFactory.createMaxXYDataSignificanceBarChartRenderer(table, column,
				plotOrientation, maxValue, positiveValuesColor,
				nonSignificantValuesColor, significanceLevel);
	}

	private void checkMaxValue() {
		if (this.maxValue == null) {
			this.maxValue = TableUtils.getMaxColumnValue(table, column);
		}
	}
}
