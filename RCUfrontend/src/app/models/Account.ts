export class Account {

    accountId: number;
    ownerId: number;
    balance:number;
    type:number;
    constructor(
        accountId: number,
        ownerId: number,
        balance:number,
        type:number
    ) {
        this.accountId = accountId;
        this.ownerId = ownerId;
        this.balance = balance;
        this.type = type;
    }

}