export class Account {

    accountId: number;
    ownerId: number;
    balance:number;
    constructor(
        accountId: number,
        ownerId: number,
        balance:number,
    ) {
        this.accountId = accountId;
        this.ownerId = ownerId;
        this.balance = balance;
    }

}