package pl.edu.pja.stable.entity;

/**
 * Created by Magdalena on 2017-06-16.
 */

import javax.persistence.Entity;
import javax.persistence.Persistence;
import javax.persistence.Table;

@Entity
@Table(name = "client")
public class Client extends Person{
}
