package com.tokentracker.bean;

import java.util.List;

public class TokenTransferBean {

    private String status;
    private String message;
    private List<Result> result;
    public void setStatus(String status) {
        this.status = status;
    }
    public String getStatus() {
        return status;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    public String getMessage() {
        return message;
    }

    public void setResult(List<Result> result) {
        this.result = result;
    }
    public List<Result> getResult() {
        return result;
    }

    public class Result {

        private String blockNumber;
        private String timeStamp;
        private String hash;
        private String nonce;
        private String blockHash;
        private String from;
        private String contractAddress;
        private String to;
        private String value;
        private String tokenName;
        private String tokenSymbol;
        private String tokenDecimal;
        private String transactionIndex;
        private String gas;
        private String gasPrice;
        private String gasUsed;
        private String cumulativeGasUsed;
        private String input;
        private String confirmations;
        public void setBlockNumber(String blockNumber) {
            this.blockNumber = blockNumber;
        }
        public String getBlockNumber() {
            return blockNumber;
        }

        public void setTimeStamp(String timeStamp) {
            this.timeStamp = timeStamp;
        }
        public String getTimeStamp() {
            return timeStamp;
        }

        public void setHash(String hash) {
            this.hash = hash;
        }
        public String getHash() {
            return hash;
        }

        public void setNonce(String nonce) {
            this.nonce = nonce;
        }
        public String getNonce() {
            return nonce;
        }

        public void setBlockHash(String blockHash) {
            this.blockHash = blockHash;
        }
        public String getBlockHash() {
            return blockHash;
        }

        public void setFrom(String from) {
            this.from = from;
        }
        public String getFrom() {
            return from;
        }

        public void setContractAddress(String contractAddress) {
            this.contractAddress = contractAddress;
        }
        public String getContractAddress() {
            return contractAddress;
        }

        public void setTo(String to) {
            this.to = to;
        }
        public String getTo() {
            return to;
        }

        public void setValue(String value) {
            this.value = value;
        }
        public String getValue() {
            return value;
        }

        public void setTokenName(String tokenName) {
            this.tokenName = tokenName;
        }
        public String getTokenName() {
            return tokenName;
        }

        public void setTokenSymbol(String tokenSymbol) {
            this.tokenSymbol = tokenSymbol;
        }
        public String getTokenSymbol() {
            return tokenSymbol;
        }

        public void setTokenDecimal(String tokenDecimal) {
            this.tokenDecimal = tokenDecimal;
        }
        public String getTokenDecimal() {
            return tokenDecimal;
        }

        public void setTransactionIndex(String transactionIndex) {
            this.transactionIndex = transactionIndex;
        }
        public String getTransactionIndex() {
            return transactionIndex;
        }

        public void setGas(String gas) {
            this.gas = gas;
        }
        public String getGas() {
            return gas;
        }

        public void setGasPrice(String gasPrice) {
            this.gasPrice = gasPrice;
        }
        public String getGasPrice() {
            return gasPrice;
        }

        public void setGasUsed(String gasUsed) {
            this.gasUsed = gasUsed;
        }
        public String getGasUsed() {
            return gasUsed;
        }

        public void setCumulativeGasUsed(String cumulativeGasUsed) {
            this.cumulativeGasUsed = cumulativeGasUsed;
        }
        public String getCumulativeGasUsed() {
            return cumulativeGasUsed;
        }

        public void setInput(String input) {
            this.input = input;
        }
        public String getInput() {
            return input;
        }

        public void setConfirmations(String confirmations) {
            this.confirmations = confirmations;
        }
        public String getConfirmations() {
            return confirmations;
        }

    }


}
