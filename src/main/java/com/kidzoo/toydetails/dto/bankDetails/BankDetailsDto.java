package com.kidzoo.toydetails.dto.bankDetails;

    public class BankDetailsDto {
        private String accountHolderName;

        private String accountNumber;

        private String bankName;

        private String IFSCCode;

        public BankDetailsDto() {
        }

        public BankDetailsDto(String accountHolderName, String accountNumber, String bankName, String IFSCCode) {
            this.accountHolderName = accountHolderName;
            this.accountNumber = accountNumber;
            this.bankName = bankName;
            this.IFSCCode = IFSCCode;
        }


        public String getAccountHolderName() {
            return accountHolderName;
        }

        public BankDetailsDto setAccountHolderName(String accountHolderName) {
            this.accountHolderName = accountHolderName;
            return this;
        }

        public String getAccountNumber() {
            return accountNumber;
        }

        public BankDetailsDto setAccountNumber(String accountNumber) {
            this.accountNumber = accountNumber;
            return this;
        }

        public String getBankName() {
            return bankName;
        }

        public BankDetailsDto setBankName(String bankName) {
            this.bankName = bankName;
            return this;
        }

        public String getIFSCCode() {
            return IFSCCode;
        }

        public BankDetailsDto setIFSCCode(String IFSCCode) {
            this.IFSCCode = IFSCCode;
            return this;
        }
    }
