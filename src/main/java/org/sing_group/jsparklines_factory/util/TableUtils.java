package org.sing_group.jsparklines_factory.util;

import static java.util.stream.Collectors.toList;

import java.util.LinkedList;
import java.util.List;

import javax.swing.JTable;
import javax.swing.table.TableModel;

import no.uib.jsparklines.data.XYDataPoint;

public class TableUtils {
	public static Double getMaxColumnValue(JTable table, int col) {
		return getColumnDoubleValues(table, col).stream().mapToDouble(d -> d)
			.max().orElse(Double.NaN);
	}

	public static Double getMinColumnValue(JTable table, int col) {
		return getColumnDoubleValues(table, col).stream().mapToDouble(d -> d)
			.min().orElse(Double.NaN);
	}

	private static List<Double> getColumnDoubleValues(JTable table, int col) {
		TableModel tableModel = table.getModel();
		requireNumberclass(tableModel.getColumnClass(col));
		List<Object> columnValues = getColumnValues(tableModel, col);
		return columnValues.stream().map(TableUtils::toDouble).collect(toList());
	}

	private static void requireNumberclass(Class<?> columnClass) {
		if (!Number.class.isAssignableFrom(columnClass)	&&
			!XYDataPoint.class.isAssignableFrom(columnClass) &&
			!isPrimitiveNumeric(columnClass)
		) {
			throw new IllegalStateException("Numeric or XYDataPoint column required");
		}
	}

	private static boolean isPrimitiveNumeric(Class<?> columnClass) {
		return double.class.isAssignableFrom(columnClass)
			|| float.class.isAssignableFrom(columnClass)
			|| int.class.isAssignableFrom(columnClass)
			|| long.class.isAssignableFrom(columnClass);
	}

	public static Double toDouble(Object value) {
		if (Number.class.isAssignableFrom(value.getClass())) {
			return ((Number) value).doubleValue();
		} else if (XYDataPoint.class.isAssignableFrom(value.getClass())) {
			return ((XYDataPoint) value).getX();
		} else {
			throw new IllegalArgumentException("Numeric or XYDataPoint column required");
		}
	}

	private static List<Object> getColumnValues(TableModel tableModel,
		int col) {
		List<Object> values = new LinkedList<>();
		for (int row = 0; row < tableModel.getRowCount(); row++) {
			values.add(tableModel.getValueAt(row, col));
		}
		return values;
	}
}
