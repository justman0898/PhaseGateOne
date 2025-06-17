from menstrual_app_functions import * 
def main():
    last_period_date = None
    average_cycle_length = 0
    period_length = 0

    while True:
        print("""
=== Welcome to Semicolon Period Tracker ===
1. SIGN UP : Let's get some basic details about you.
2. VIEW PERIOD INFO: View your next period date, fertile days etc.
How to Measure It:
Mark the first day of your period (Day 1).
Count up to the day before your next period starts.
That number is your cycle length.
0. EXIT......
        """)

        try:
            user_input = int(input("Choose an option: "))
        except ValueError:
            print("Wrong Input")
            continue

        if user_input == 1:
            while True:
                try:
                    last_period_date = input("Enter the Start Date of your Last period (YYYY-MM-DD): ")
                    datetime.strptime(last_period_date, "%Y-%m-%d")
                    average_cycle_length = int(input("Enter your average cycle length: "))
                    period_length = int(input("Enter your average period length: "))
                    print("Thank you for Signing up!\n")
                    back = input("0. BACK: ")
                    if back == "0":
                        break
                except ValueError:
                    print("Wrong Input")

        elif user_input == 2:
            if not last_period_date:
                input("No profile Created. Press Enter to continue...")
                continue
            try:
                printCalendar(last_period_date)
                print()
                next_period = calculate_next_period_date(last_period_date, average_cycle_length)
                ovulation_day = ovulation(last_period_date, average_cycle_length)

                print(f"\nYour next period is expected on: {next_period}")
                print(f"Estimated ovulation day: {ovulation_day}")
                print(fertile_window(last_period_date, average_cycle_length))
                print(period_window(last_period_date, average_cycle_length, period_length))
                input("0. BACK: ")
            except Exception as e:
                input(f"An error occurred: {e}. Press Enter to continue...")

        elif user_input == 0:
            break
        else:
            print("Enter a valid input!")


print(main())