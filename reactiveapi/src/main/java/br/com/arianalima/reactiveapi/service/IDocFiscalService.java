package br.com.arianalima.reactiveapi.service;

import br.com.arianalima.reactiveapi.model.DocFiscal;

public interface IDocFiscalService {

	public void realizarAutorizacaoAPIExterna(Long idCliente, Integer idServico, String protocolo);
	public DocFiscal consultarPorProtocolo(String protocolo);
}