package br.com.arianalima.account.dto;

public record TransferDTO(Integer debitAccountNumber, Integer creditAccountNumber, Double amount) {

}