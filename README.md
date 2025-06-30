# Java Banking System

A simple command-line **banking system** in Java that supports multiple account types, deposits, withdrawals, transfers, and account listing.

## Features

- **Create Accounts:** Current, Savings, and Premium Deposit accounts
- **Deposit & Withdraw:** With account-specific rules and interest
- **Transfer:** Between eligible accounts
- **Account Listing:** View all account details

## Account Types

| Account Type            | Interest Rate | Transfer Allowed | Withdrawal Rules                                      |
|-------------------------|---------------|------------------|-------------------------------------------------------|
| Current Account         | 0%            | Yes              | No minimum balance required                            |
| Savings Account         | 2.5%          | Yes              | Must keep at least 1000 after withdrawal               |
| Premium Deposit Account | 7%            | No               | At least 5 deposits before first withdrawal            |

