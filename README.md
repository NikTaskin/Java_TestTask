# SHIST_Java_TestTask


## Тестовое задание. Курс Java. ШИФТ ЦФТ


### Утилита фильтрации содержимого файлов
При запуске утилиты в командной строке подается несколько файлов, содержащих в
перемешку целые числа, строки и натуральные числа. В качестве разделителя
используется перевод строки. Строки из файлов читаются по очереди в соответствии с их
перечислением в командной строке.
Утилита записывает разные типы данных в разные файлы. Целые числа в один
выходной файл, натуральные в другой, строки в третий. По умолчанию файлы с
результатами располагаются в текущей папке с именами integers.txt, floats.txt, strings.txt


### Инструкция по сборке и запуску
1. Убедитесь, что на вашем копьютере установлена версия Java 19 и выше
2. Убедитесь, что на вашем компьютере установлена версия Maven 3.9.3 и выше
3. Скачайте репозиторий на локальный компьютер или склонируйте его с помошью команды
   ```
   git clone https://github.com/NikTaskin/Java_TestTask.git
   ```
5. Соберите проект с помошью Maven командой
   ```
   mvn clean package
   ```
6. Запустите проект командой
   ```
   java -jar target/ContentFilterUtility-1.0.jar [-flags] file1.txt file2.txt ... fileN.txt
   ```
7. Можете воспользоваться уже собранным проектом в корневой папке проекта ContentFilterUtility-1.0.jar и текстовыми файлами in1.txt и in2.txt

### Опции и флаги
* -o <path>: Задает путь для результатов. По умолчанию файлы результатов располагаются в текущей папке
* -p <prefix>: Задает префикс имен выходных файлов. Например, -p result_ приведет к созданию файлов вида
  result_integers.txt, result_strings.txt, result_floats.txt
* -a: Режим добавления в существующие файлы. По умолчанию файлы результатов перезаписываются
* -s: Вывести краткую статистику. Показывает только количество элементов записанных в исходящие файлы.
* -f: Вывести полную статистику. Помимо количества элементов, для чисел выводит минимальное, максимальное, сумму и среднее значения,
  а для строк – размер самой короткой и самой длинной строки