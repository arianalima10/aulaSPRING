package br.com.arianalima.account.service;

import br.com.arianalima.account.dto.TransferDTO;
import br.com.arianalima.account.model.Transaction;

public interface ITransferService {
	public Transaction transferValues(TransferDTO transferDto);

}