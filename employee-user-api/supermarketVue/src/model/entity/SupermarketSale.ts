// in js, the class object would auto inherit serializable, so it do not need to implement serializable like java
class SupermarketSale {
    id: number | null;
    branch: string | null;
    city: string | null;
    customerType: string | null;
    gender: string | null;
    productLine: string | null;
    unitPrice: number | null;
    quantity: number | null;
    tax5Percent: number | null;
    total: number | null;
    date: Date | null;
    time: Date | null;
    payment: string | null;
    cogs: number | null;
    grossMarginPercentage: number | null;
    grossIncome: number | null;
    rating: number | null;

    constructor(
        id: number| null,
        branch: string| null,
        city: string| null,
        customerType: string| null,
        gender: string| null,
        productLine: string| null,
        unitPrice: number| null,
        quantity: number| null,
        tax5Percent: number| null,
        total: number| null,
        date: Date| null,
        time: Date| null,
        payment: string| null,
        cogs: number| null,
        grossMarginPercentage: number| null,
        grossIncome: number| null,
        rating: number| null
    ) {
        this.id = id;
        this.branch = branch;
        this.city = city;
        this.customerType = customerType;
        this.gender = gender;
        this.productLine = productLine;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
        this.tax5Percent = tax5Percent;
        this.total = total;
        this.date = date;
        this.time = time;
        this.payment = payment;
        this.cogs = cogs;
        this.grossMarginPercentage = grossMarginPercentage;
        this.grossIncome = grossIncome;
        this.rating = rating;
    }
}

export default SupermarketSale;