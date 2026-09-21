package tema0.repaso;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BookCollection {
    private List<Book> libros;

    public BookCollection(List<Book> libros) {
        this.libros = libros;
    }

    //1. obtener libros con mas de 500 paginas
    public void librosLargos(List<Book> libros){
        List<Book> largos = libros.stream().filter(p -> p.pages() > 500).toList();
        System.out.println("Libros con más de 500 páginas: "+largos.size());
    }
    //2. obtener libros con menos de 300 paginas
    public void librosCortos(List<Book> libros){
        List<Book> cortos = libros.stream().filter(p -> p.pages() < 300).toList();
        System.out.println("Libros con menos de 300 páginas: "+cortos.size());
    }
    //3. obtener Títulos de los libros con mas de 500 paginas
    public void largosTitulo(List<Book> libros){
        List<Book> largos = libros.stream().filter(p -> p.pages() > 500).toList();
        largos.stream().map(Book::title).forEach(titulo -> System.out.println("Título: " + titulo));
    }
    //4. obtener Títulos de los 3 libros mas granders
    public void tresLargos(List<Book> libros){
        List<Book> largos = libros.stream().filter(p -> p.pages() > 500).toList();
        largos.stream().map(Book::title).limit(3).forEach(titulo -> System.out.println("Título: " + titulo));
    }

    public void sumaPaginas(List<Book> libros){
        int suma = 0;
        for (Book libro : libros) {
            suma += libro.pages();
        }
        System.out.println("La suma de los libros es igual a "+suma );
    }
    public void superarPromedio(List<Book> libros){
        int suma = 0;
        for (Book libro : libros) {
            suma += libro.pages();
        }
        int mid = suma/libros.size();
        System.out.println("Páginas promedio" + mid);
        List<Book> largos = libros.stream().filter(p -> p.pages() > mid).toList();
        largos.stream().map(Book::title).forEach(titulo -> System.out.println("Título: " + titulo));
    }
    public void autoresSinRepetir(List<Book> libros) {
        List<String> autoresUnicos = libros.stream().map(Book::author).distinct().toList();
        System.out.println("Autores (sin repetir): " + autoresUnicos);
    }

    public void autoresMuchosLibros(List<Book> libros) {
        Map<String, Long> conteoAutor = libros.stream().collect(Collectors.groupingBy(Book::author, Collectors.counting()));

        List<String> autoresRepetidos = conteoAutor.entrySet().stream().filter(entrada -> entrada.getValue() > 1)
                .map(Map.Entry::getKey).toList();
        System.out.println("Autores con más de 1 libro: "+autoresRepetidos);
    }
}
