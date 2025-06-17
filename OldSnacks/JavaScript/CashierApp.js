class CashierMachine {
    static VAT_RATE = 0.175;

    constructor() {
        this.itemsQuantityPrices = [];  // Array of arrays
        this.name = '';
        this.discount = 0.0; // As percentage, e.g., 15 becomes 0.15
    }

    setName(name) {
        this.name = name;
    }

    getName() {
        return this.name;
    }

    setDiscount(percentage) {
        this.discount = percentage / 100;
    }

    getDiscount() {
        return this.discount;
    }

    addItem(item, quantity, price) {
        this.itemsQuantityPrices.push([item, quantity, price.toString()]);
    }

    viewAllItems() {
        return this.itemsQuantityPrices;
    }

    getTotal() {
        let subTotal = 0;
        for (let row of this.itemsQuantityPrices) {
            let quantity = parseInt(row[1]);
            let price = parseFloat(row[2]);
            subTotal += quantity * price;
        }
        return subTotal;
    }

    addTotal() {
        for (let i = 0; i < this.itemsQuantityPrices.length; i++) {
            const row = this.itemsQuantityPrices[i];
            if (row.length < 4) {
                let quantity = parseInt(row[1]);
                let price = parseFloat(row[2]);
                let total = quantity * price;
                this.itemsQuantityPrices[i].push(total.toFixed(2));
            }
        }

        for (let row of this.itemsQuantityPrices) {
            console.log(row.map(val => `\t${val}\t`).join(''));
        }
    }

    getDiscountAmount() {
        return this.getTotal() * this.getDiscount();
    }

    getVatValue() {
        return this.getTotal() * CashierMachine.VAT_RATE;
    }

    getTotalBill() {
        return this.getTotal() - this.getDiscountAmount() + this.getVatValue();
    }

    printReceiptHeader() {
        const now = new Date();
        const dateStr = now.toLocaleDateString();
        const timeStr = now.toLocaleTimeString();

        return `
SEMICOLON STORES
MAIN BRANCH
LOCATION: 312, HERBERT MACAULAY WAY, SABO YABA, LAGOS.
TEL: 09068325098
Date: ${dateStr} ${timeStr}
Cashier: Cashier's name
Customer's Name: ${this.getName()}
============================================================================
    Item(s)      QTY            PRICE           TOTAL(N)
---------------------------------------------------------------------------
        `;
    }

    printRestOfSlip() {
        const subTotal = this.getTotal();
        const discount = this.getDiscountAmount();
        const vat = this.getVatValue();
        const total = this.getTotalBill();

        return `
---------------------------------------------------------------------------
                    SubTotal:     ${subTotal.toFixed(2)}
                    Discount:     ${discount.toFixed(2)}
                    Vat @ 17.5%:  ${vat.toFixed(2)}
===========================================================================
                    Bill Total:   ${total.toFixed(2)}
===========================================================================
THIS IS NOT A RECEIPT. KINDLY PAY ${total.toFixed(2)}

How much did the customer give to you? 
        `;
    }

    printFullReceipt(name) {
        this.setName(name);
        console.log(this.printReceiptHeader());
        this.addTotal();
        console.log(this.printRestOfSlip());
    }

    getCustomerBalance(amountPaid) {
        const total = this.getTotalBill();
        if (amountPaid >= total) {
            return amountPaid - total;
        } else {
            throw new Error("Amount paid cannot be less than bill.");
        }
    }

    printFinalReceipt(amountPaid) {
        const subTotal = this.getTotal();
        const discount = this.getDiscountAmount();
        const vat = this.getVatValue();
        const total = this.getTotalBill();
        const balance = this.getCustomerBalance(amountPaid);

        return `
----------------------------------------------------------------------
                    SubTotal:     ${subTotal.toFixed(2)}
                    Discount:     ${discount.toFixed(2)}
                    Vat @ 17.5%:  ${vat.toFixed(2)}
======================================================================
                    Bill Total:   ${total.toFixed(2)}
                    Amount Paid:  ${amountPaid.toFixed(2)}
                    Balance:      ${balance.toFixed(2)}
======================================================================
            THANK YOU FOR YOUR PATRONAGE
======================================================================
        `;
    }

    printFullFinalReceipt(amountPaid, name) {
        this.setName(name);
        console.log(this.printReceiptHeader());
        this.addTotal();
        console.log(this.printFinalReceipt(amountPaid));
    }
}





const prompt = require('prompt-sync')({ sigint: true });
const cashier = new CashierMachine();

let name, item, quantity, price, discount, amount;
let isValid = true;

console.log("Enter Customer's Name:");
name = prompt("> ");
cashier.setName(name);

while (isValid) {
    try {
        console.log("What did the customer buy?");
        item = prompt("> ");

        console.log("How many pieces?");
        quantity = prompt("> ");
        if (isNaN(parseInt(quantity))) throw new Error("Invalid quantity");

        console.log("How much per unit?");
        price = prompt("> ");
        if (isNaN(parseFloat(price))) throw new Error("Invalid price");

        cashier.addItem(item, quantity, price);

        let inAddMore = true;
        while (inAddMore) {
            console.log("Add more item? (yes/no)");
            let userInput = prompt("> ").toLowerCase();

            switch (userInput) {
                case "yes":
                    console.log("What did the customer buy?");
                    item = prompt("> ");

                    console.log("How many pieces?");
                    quantity = prompt("> ");
                    if (isNaN(parseInt(quantity))) throw new Error("Invalid quantity");

                    console.log("How much per unit?");
                    price = prompt("> ");
                    if (isNaN(parseFloat(price))) throw new Error("Invalid price");

                    cashier.addItem(item, quantity, price);
                    break;

                case "no":
                    console.log("How much discount will they get? (%)");
                    discount = prompt("> ");
                    if (isNaN(parseFloat(discount))) throw new Error("Invalid discount");

                    cashier.setDiscount(parseFloat(discount));
                    cashier.printFullReceipt(name);

                    console.log("How much did the customer give to you?");
                    amount = prompt("> ");
                    if (isNaN(parseFloat(amount))) throw new Error("Invalid amount");

                    cashier.printFullFinalReceipt(parseFloat(amount), name);

                    inAddMore = false;
                    isValid = false;
                    break;

                default:
                    console.log("Please type 'yes' or 'no'.");
            }
        }
    } catch (err) {
        console.log("We noticed you might have input the wrong info, try again...");
    }
}


