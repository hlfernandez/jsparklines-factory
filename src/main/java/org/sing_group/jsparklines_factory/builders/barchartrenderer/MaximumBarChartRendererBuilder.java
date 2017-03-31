package org.sing_group.jsparklines_factory.builders.barchartrenderer;

import javax.swing.JTable;

import org.jfree.chart.plot.PlotOrientation;
import org.sing_group.jsparklines_factory.JSparklinesBarChartTableCellRendererFactory;
import org.sing_group.jsparklines_factory.util.TableUtils;

import no.uib.jsparklines.renderers.JSparklinesBarChartTableCellRenderer;

public class MaximumBarChartRendererBuilder {

	private JTable table;
	private int column;
	private PlotOrientation plotOrientation = JSparklinesBarChartTableCellRendererFactory.DEFAULT_ORIENTATION;
	private Double maxValue;
	private boolean largeNumbersAreGood = JSparklinesBarChartTableCellRendererFactory.DEFAULT_LARGE_NUMBERS_ARE_GOOD;

	public MaximumBarChartRendererBuilder(JTable table, int column) {
		this.table = table;
		this.column = column;
	}

	public MaximumBarChartRendererBuilder withPlotOrientation(
		PlotOrientation plotOrientation
	) {
		this.plotOrientation = plotOrientation;
		return this;
	}

	public MaximumBarChartRendererBuilder withMaxValue(
		Double maxValue
	) {
		this.maxValue = maxValue;
		return this;
	}
	
	public MaximumBarChartRendererBuilder largeNumbersAreGood(
		boolean largeNumbersAreGood
	) {
		this.largeNumbersAreGood = largeNumbersAreGood;
		return this;
	}

	public JSparklinesBarChartTableCellRenderer build() {
		checkMaxValue();

		return JSparklinesBarChartTableCellRendererFactory
			.createMaxValueBarChartRenderer(table, column,
				plotOrientation, maxValue, largeNumbersAreGood);
	}

	private void checkMaxValue() {
		if (this.maxValue == null) {
			this.maxValue = TableUtils.getMaxColumnValue(table, column);
		}
	}
}
