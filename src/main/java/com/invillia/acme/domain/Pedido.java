package com.invillia.acme.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_pedido")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pedido")
    private Long id;

    @Column(name = "status")
    private Boolean status = false;

    @Column(name = "dt_confirmacao")
    private Date dataConfirmacao;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @OneToOne
    @JoinColumn(name = "id_loja")
    private Loja loja;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pedido")
    private List<ItensPedido> itensPedido;

}
