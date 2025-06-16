from datetime import datetime, timedelta


def calculate_next_period_date(last_period_date, average_cycle_length):
	last_period = datetime.strptime(last_period_date, "%Y-%m-%d").date()
	next_day = last_period + timedelta(days=average_cycle_length)
	return next_day


def ovulation(last_period_date, average_cycle_length):
	next_day = calculate_next_period_date(last_period_date, average_cycle_length)
	ovulation_day = next_day - timedelta(days=14)
	return ovulation_day

def fertile_window(last_period_date, average_cycle_length):
	day_ovulation = ovulation(last_period_date, average_cycle_length)
	start_day = day_ovulation -timedelta(days=5)
	end_day = start_day + timedelta(days=6)
	
	message = f"""
Your fertile Window starts on {start_day}
It can typically go up to 6 days
Ends at: {end_day}
"""
	return message

def period_window(last_period_date, average_cycle_length, avaerage_period_length):
	day_period = calculate_next_period_date(last_period_date, average_cycle_length)
	end = day_period + timedelta(days=avaerage_period_length)
	message = f"""
Your period starts on {day_period} and
Ends at: {end}
"""
	return message

def printCalendar(date):
	day = datetime.strptime(date, "%Y-%m-%d").date()
	month_value = day.month
	months = [0,31,28,31,30,31,30,31,31,30,31,30,31]
	days_in_the_month = months[month_value]
	for num in range(1, days_in_the_month + 1):
		print(f"{num:4d}", end='')
		if(num % 7 == 0):
			print();
			
		

printCalendar("2025-05-28")
date = "2025-05-28"
print(period_window(date, 28, 5))
print(fertile_window(date, 28))




