import credit_card
def main():
    print("Hello, kindly enter card details to verify")
    
    try:
        card_input = input("> ").strip()
        card_array = credit_card.convert_string_to_array(card_input)

        if credit_card.check_for_negative(card_array) or not credit_card.validate_card_length(card_array):
            print("Invalid input: only digits 0–9 allowed and length must be 13–16.")
            return

        print(credit_card.print_output(card_array))

    except ValueError:
        print("We detected that you entered the wrong data type. Try again...")

print(main())