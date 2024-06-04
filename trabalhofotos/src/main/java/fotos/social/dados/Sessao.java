package fotos.social.dados;

import java.time.LocalDateTime;

public class Sessao {
    private int id;
    private Usuario loggedAs;
    private LocalDateTime tempoEntrada;    

    // Sessão não pode ser criada vazia e não pode ser modificada.
    // TODO -> Implementação de id atrelado a banco de dados.
    public Sessao(int id, Usuario loggedAs) {
        this.id = id;
        this.tempoEntrada = LocalDateTime.now();
        this.loggedAs = loggedAs;
    }


    public int getId() {
        return id;
    }

    public LocalDateTime getTempoEntrada() {
        return tempoEntrada;
    }

    public Usuario getLoggedAs() {
        return loggedAs;
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        return result;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Sessao other = (Sessao) obj;
        if (id != other.id)
            return false;
        return true;
    }

        


}
