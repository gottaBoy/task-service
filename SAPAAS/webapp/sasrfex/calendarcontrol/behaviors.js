//alter by daiyw
var srfrules = {
	'input.srfdatepicker': function(elt) {
		new Control.DatePicker(elt, { icon: '../sasrfex/calendarcontrol/calendar.png' });
	},
	'input.srftimepicker': function(elt) {
		new Control.DatePicker(elt, { icon: '../sasrfex/calendarcontrol/clock.png', datePicker: false, timePicker: true });
	},
	'input.srfdatetimepicker': function(elt) {
		new Control.DatePicker(elt, { icon: '../sasrfex/calendarcontrol/calendar.png', timePicker: true, timePickerAdjacent: true, use24hrs: true });
	}
//	'input.datetimepicker_es': function(elt) {
//		new Control.DatePicker(elt, { icon: '../CalendarControl/calendar.png', locale:'es_AR', timePicker: true });
//	}
};
