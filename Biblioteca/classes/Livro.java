package Biblioteca.classes;

public class Livro {
        private String titulo;
        private String autor;
        private int ano;
        private boolean disponivel;

        public Livro(String titulo, String autor, int ano, boolean disponivel) {
            this.titulo = titulo;
            this.autor = autor;
            this.ano = ano;
            this.disponivel = disponivel;
        }

        public String getTitulo() {
            return this.titulo;
        }

        public String getAutor() {
            return this.autor;
        }

        public int getAno() {
            return this.ano;
        }

        public boolean estaDisponivel() {
            return this.disponivel;
        }

        public void changeTitulo(String novoTitulo) {
            this.titulo = novoTitulo;
        }

        public void changeAutor(String novoAutor) {
            this.autor = novoAutor;
        }

        public void updateAno(int novoAno) {
            this.ano = novoAno;
        }

        public void emprestar() {
            if (this.disponivel) {
                this.disponivel = false;
                System.out.println("O livro foi emprestado com sucesso.");
            } else {
                System.out.println("Não foi possível emprestar livro. Não disponível.");
            }
        }

        public void devolver() {
            if (!this.disponivel) {
                this.disponivel = true;
                System.out.println("O livro foi devolvido com êxito.");
            } else {
                System.out.println("Não foi possivel devolver livro, não se encontra emprestado.");
            }
        }

        public int CorredorAlocado() {
            if (this.ano <= 2000 && this.ano > 1990) {
                return 1;
            } else if (this.ano <= 2010 && this.ano > 2000) {
                return 1;
            } else if (this.ano <= 2020 && this.ano > 2010) {
                return 3;
            } else {
                return 4;
            }
        }

        public int findPrice() {
            if (this.ano > 1990 && this.ano < 2000) {
                return 20;
            } else if (this.ano > 2000 && this.ano < 2010) {
                return 30;
            } else if (this.ano > 2010 && this.ano < 2020) {
                return 40;
            } else {
                return 50;
            }
        }
    }
