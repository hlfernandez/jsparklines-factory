package org.sing_group.jsparklines_factory.builders.barchartrenderer;

import java.awt.Color;

import javax.swing.JTable;

import org.jfree.chart.plot.PlotOrientation;
import org.sing_group.jsparklines_factory.JSparklinesBarChartTableCellRendererFactory;
import org.sing_group.jsparklines_factory.util.TableUtils;

import no.uib.jsparklines.renderers.JSparklinesBarChartTableCellRenderer;

public class MaximumMinimumXYDataSignificanceBarChartRendererBuilder {

	private JTable table;
	private int column;
	private PlotOrientation plotOrientation = JSparklinesBarChartTableCellRendererFactory.DEFAULT_ORIENTATION;
	private Double maxValue;
	private Double minValue;
	private Color positiveValuesColor = JSparklinesBarChartTableCellRendererFactory.DEFAULT_POSITIVES_COLOR;
	private Color negativeValuesColor = JSparklinesBarChartTableCellRendererFactory.DEFAULT_NEGATIVES_COLOR;
	private Color nonSignificantValuesColor = JSparklinesBarChartTableCellRendererFactory.DEFAULT_NON_SIGNIFICANT_COLOR;
	private Double significanceLevel = JSparklinesBarChartTableCellRendererFactory.DEFAULT_SIGNIFICANCE_LEVEL;

	public MaximumMinimumXYDataSignificanceBarChartRendererBuilder(JTable table, int column) {
		this.table = table;
		this.column = column;
	}

	public MaximumMinimumXYDataSignificanceBarChartRendererBuilder withPlotOrientation(
		PlotOrientation plotOrientation
	) {
		this.plotOrientation = plotOrientation;
		return this;
	}

	public MaximumMinimumXYDataSignificanceBarChartRendererBuilder withMaxValue(
		Double maxValue
	) {
		this.maxValue = maxValue;
		return this;
	}

	public MaximumMinimumXYDataSignificanceBarChartRendererBuilder withPositiveValuesColor(
		Color positiveValuesColor
	) {
		this.positiveValuesColor = positiveValuesColor;
		return this;
	}

	public MaximumMinimumXYDataSignificanceBarChartRendererBuilder withMinValue(
		Double minValue
	) {
		this.minValue = minValue;
		return this;
	}

	public MaximumMinimumXYDataSignificanceBarChartRendererBuilder withNegativeValuesColor(
		Color negativeValuesColor
	) {
		this.negativeValuesColor = negativeValuesColor;
		return this;
	}

	public MaximumMinimumXYDataSignificanceBarChartRendererBuilder withNonSignificanteValuesColor(
		Color nonSignificantValuesColor
	) {
		this.nonSignificantValuesColor = nonSignificantValuesColor;
		return this;
	}

	public MaximumMinimumXYDataSignificanceBarChartRendererBuilder withSignificanceLevel(
		Double significanceLevel
	) {
		this.significanceLevel = significanceLevel;
		return this;
	}

	public JSparklinesBarChartTableCellRenderer build() {
		checkMaxMinValues();

		return JSparklinesBarChartTableCellRendererFactory
			.createMaxMinXYDataSignificanceBarChartRenderer(table, column,
				plotOrientation, minValue, maxValue, negativeValuesColor,
				positiveValuesColor, nonSignificantValuesColor, significanceLevel);
	}

	private void checkMaxMinValues() {
		if (this.maxValue == null) {
			this.maxValue = TableUtils.getMaxColumnValue(table, column);
		}
		if (this.minValue == null) {
			this.minValue = TableUtils.getMinColumnValue(table, column);
		}
	}
}
