package comptoirs.entity;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.Size;

import lombok.*;

@Entity
@Getter @Setter @NoArgsConstructor @RequiredArgsConstructor @ToString
public class Categorie {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Setter(AccessLevel.NONE) // la clé est auto-générée par la BD, On ne veut pas de "setter"
	private Integer code;

	@NonNull
	@Size(min = 1, max = 255)
	@Column(unique=true, length = 255)
	private String libelle;

	@Size(max = 255)
	@Column(length = 255)
	private String description;

	@ToString.Exclude
	@OneToMany(mappedBy = "categorie", cascade = CascadeType.PERSIST)
	private List<Produit> produits = new LinkedList<>();

}
