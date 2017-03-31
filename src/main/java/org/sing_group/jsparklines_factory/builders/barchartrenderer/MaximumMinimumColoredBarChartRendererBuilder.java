package org.sing_group.jsparklines_factory.builders.barchartrenderer;

import static org.sing_group.jsparklines_factory.JSparklinesBarChartTableCellRendererFactory.DEFAULT_ORIENTATION;
import static org.sing_group.jsparklines_factory.JSparklinesBarChartTableCellRendererFactory.DEFAULT_POSITIVES_COLOR;
import static org.sing_group.jsparklines_factory.JSparklinesBarChartTableCellRendererFactory.DEFAULT_NEGATIVES_COLOR;
import static org.sing_group.jsparklines_factory.JSparklinesBarChartTableCellRendererFactory.createMaxMinValuesColoredBarChartRenderer;

import java.awt.Color;

import javax.swing.JTable;

import org.jfree.chart.plot.PlotOrientation;
import org.sing_group.jsparklines_factory.util.TableUtils;

import no.uib.jsparklines.renderers.JSparklinesBarChartTableCellRenderer;

public class MaximumMinimumColoredBarChartRendererBuilder {

	private JTable table;
	private int column;
	private PlotOrientation plotOrientation = DEFAULT_ORIENTATION;
	private Double maxValue;
	private Double minValue;
	private Color positiveValuesColor = DEFAULT_POSITIVES_COLOR;
	private Color negativeValuesColor = DEFAULT_NEGATIVES_COLOR;

	public MaximumMinimumColoredBarChartRendererBuilder(JTable table, int column) {
		this.table = table;
		this.column = column;
	}

	public MaximumMinimumColoredBarChartRendererBuilder withPlotOrientation(
		PlotOrientation plotOrientation
	) {
		this.plotOrientation = plotOrientation;
		return this;
	}

	public MaximumMinimumColoredBarChartRendererBuilder withMaxValue(
		Double maxValue
	) {
		this.maxValue = maxValue;
		return this;
	}
	
	public MaximumMinimumColoredBarChartRendererBuilder withPositiveValuesColor(
		Color positiveValuesColor 
	) {
		this.positiveValuesColor = positiveValuesColor;
		return this;
	}

	public MaximumMinimumColoredBarChartRendererBuilder withMinValue(
		Double minValue
	) {
		this.minValue = minValue;
		return this;
	}
	
	public MaximumMinimumColoredBarChartRendererBuilder withNegativeValuesColor(
		Color negativeValuesColor 
	) {
		this.negativeValuesColor = negativeValuesColor;
		return this;
	}

	public JSparklinesBarChartTableCellRenderer build() {
		checkMaxMinValues();

		return createMaxMinValuesColoredBarChartRenderer(
			table, column, plotOrientation, maxValue,
			positiveValuesColor, minValue, negativeValuesColor);
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
