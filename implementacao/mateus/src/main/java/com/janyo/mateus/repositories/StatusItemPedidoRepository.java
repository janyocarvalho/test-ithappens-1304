package com.janyo.mateus.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.janyo.mateus.domain.StatusItemPedido;

@Repository
public interface StatusItemPedidoRepository extends JpaRepository<StatusItemPedido, Integer> {

}
