from datetime import datetime, date

def validate_card_length(array):
    return 13 <= len(array) <= 16

def check_card_type(array):
    if 13 <= len(array) <= 16:
        if array[0] == 4:
            return "Visa Card"
        elif array[0] == 5:
            return "MasterCard"
        elif array[0] == 6:
            return "Discover Card"
        elif array[0] == 3 and len(array) > 1 and array[1] == 7:
            return "American Express Card"
        else:
            return "Invalid Card"
    return "Invalid Card"

def get_card_length(array):
    return len(array)

def print_card_numbers(array):
    return ''.join(str(num) for num in array)

def check_for_negative(array):
    for num in array:
        if num < 0 or num > 9:
            return True
    return False

def first_step(array):
    result = 0
    total = 0
    for i in range(len(array)):
        if i % 2 == 0:
            result = array[i] * 2
            if result > 9:
                result -= 9
            total += result
    return total

def add_digits_in_odd(array):
    total = 0
    for i in range(len(array)):
        if i % 2 != 0:
            total += array[i]
    return total

def get_sum(array):
    even_total = first_step(array)
    odd_total = add_digits_in_odd(array)
    return even_total + odd_total

def check_card(array):
    total = get_sum(array)
    return total % 10 == 0

def show_status(status):
    return "Valid" if status else "Invalid"

def print_output(array):
    card_type = check_card_type(array)
    card_number = print_card_numbers(array)
    card_length = get_card_length(array)
    validity = show_status(check_card(array))
    today = date.today()
    now = datetime.now()

    message = f"""


**********************************************
**Credit Card Type: {card_type}
**Credit Card Number: {card_number}
**Credit Card Length: {card_length}
**Credit Card Validity Status: {validity}

        Date: {today} {now.strftime('%H:%M:%S')}
**********************************************
    """
    return message

def convert_string_to_array(str_numbers):
    numbers = []
    for ch in str_numbers:
        number = int(ch)
        numbers.append(number)
    return numbers

