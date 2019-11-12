package com.invillia.acme.domain;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_pagamento")
public class PagamentoPedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pagamento")
    private Long id;

    @Column(name = "status")
    private Boolean status;

    @Column(name = "numero_cartao")
    private String numeroCartao;

    @Column(name = "dt_pagamento")
    private LocalDate dataPagamento;

    @OneToOne
    @JoinColumn(name = "tb_pedido")
    private Pedido pedido;

}
