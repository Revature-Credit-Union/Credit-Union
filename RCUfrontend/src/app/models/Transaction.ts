export interface Transaction {
    transactionID? : number,
    accountID : number,
    transactionType : number,
    amount : number
    date? : Date
}