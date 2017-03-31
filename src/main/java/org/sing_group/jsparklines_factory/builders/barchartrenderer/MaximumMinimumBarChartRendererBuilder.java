package org.sing_group.jsparklines_factory.builders.barchartrenderer;

import javax.swing.JTable;

import org.jfree.chart.plot.PlotOrientation;
import org.sing_group.jsparklines_factory.JSparklinesBarChartTableCellRendererFactory;
import org.sing_group.jsparklines_factory.util.TableUtils;

import no.uib.jsparklines.renderers.JSparklinesBarChartTableCellRenderer;

public class MaximumMinimumBarChartRendererBuilder {

	private JTable table;
	private int column;
	private PlotOrientation plotOrientation = JSparklinesBarChartTableCellRendererFactory.DEFAULT_ORIENTATION;
	private Double maxValue;
	private Double minValue;

	public MaximumMinimumBarChartRendererBuilder(JTable table, int column) {
		this.table = table;
		this.column = column;
	}

	public MaximumMinimumBarChartRendererBuilder withPlotOrientation(
		PlotOrientation plotOrientation
	) {
		this.plotOrientation = plotOrientation;
		return this;
	}

	public MaximumMinimumBarChartRendererBuilder withMaxValue(
		Double maxValue
	) {
		this.maxValue = maxValue;
		return this;
	}
	
	public MaximumMinimumBarChartRendererBuilder withMinValue(
		Double minValue
	) {
		this.minValue = minValue;
		return this;
	}

	public JSparklinesBarChartTableCellRenderer build() {
		checkMaxMinValues();

		return JSparklinesBarChartTableCellRendererFactory
			.createMaxMinValuesBarChartRenderer(table, column,
				plotOrientation, minValue,maxValue);
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
