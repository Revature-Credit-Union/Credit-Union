// This file can be replaced during build by using the `fileReplacements` array.
// `ng build` replaces `environment.ts` with `environment.prod.ts`.
// The list of file replacements can be found in `angular.json`.

export const environment = {
  production: false,
  getDeposits : "localhost:8080/transactions/findDeposits",
  getWithdrawls : "localhost:8080/transactions/findWithdrawls",
  getTransfers : "localhost:8080/transactions/findWithdrawls",
  deposit : "localhost:8080/account/deposit",
  withdraw : "llocalhost:8080/account/withdraw"
};

/*
 * For easier debugging in development mode, you can import the following file
 * to ignore zone related error stack frames such as `zone.run`, `zoneDelegate.invokeTask`.
 *
 * This import should be commented out in production mode because it will have a negative impact
 * on performance if an error is thrown.
 */
// import 'zone.js/plugins/zone-error';  // Included with Angular CLI.
