package comptoirs.entity;

import javax.persistence.*;
import javax.validation.constraints.Size;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@Getter @Setter @NoArgsConstructor @RequiredArgsConstructor @ToString
public class Commande {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(nullable = false)
	@Setter(AccessLevel.NONE) // la clé est auto-générée par la BD, On ne veut pas de "setter"
	private Integer numero;

	@Basic(optional = false)
	@NonNull
	@Column(nullable = false)
	@ToString.Exclude
	private LocalDate saisiele;

	@Basic(optional = true)
	@ToString.Exclude
	private LocalDate envoyeele;

	// @Max(value=?) @Min(value=?)//if you know range of your decimal fields
	// consider using these annotations to enforce field validation
	@Column(precision = 18, scale = 2)
	@ToString.Exclude
	private BigDecimal port;

	@Size(max = 40)
	@Column(length = 40)
	private String destinataire;

	@Size(max = 60)
	@Column(length = 60)
	@ToString.Exclude
	private String adresseLivraison;

	@Size(max = 15)
	@Column(length = 15)
	@ToString.Exclude
	private String villeLivraison;

	@Size(max = 15)
	@Column(length = 15)
	@ToString.Exclude
	private String regionLivraison;

	@Size(max = 10)
	@Column(length = 10)
	@ToString.Exclude
	private String codePostalLivraison;

	@Size(max = 15)
	@Column(length = 15)
	@ToString.Exclude
	private String paysLivraison;

	@Basic(optional = false)
	@NonNull
	@Column(nullable = false, precision = 10, scale = 2)
	private BigDecimal remise = BigDecimal.ZERO;

	@OneToMany(mappedBy = "commande")
	private List<Ligne> lignes;

	@ManyToOne(optional = false)
	@NonNull
	private Client client;

}
