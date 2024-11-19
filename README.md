# Лабораторная работа №4. Взаимодействие с сервером
**Язык программирования**: Java  
**Выполнила**: Ильичева П.Е.

## Задание лабораторной работы 

*Задание 1.* Рассмотрите пример передачи данных. 

MyAsyncTaskat = newMyAsyncTask(); 
at.execute(“url1”, “url2”); 
doInBackground(String... urls) 

*Задание 2.* Рассмотрите пример вывода промежуточных данных. 

@Override 
Protected void doInBackground(String... urls) { 
try{ 
int cnt= 0; 
for(Stringurl: urls) { 
// обрабатываем первый параметр 
… 
// выводим промежуточные результаты 
18 
cnt++; 
publishProgress(cnt); 
} 
TimeUnit.SECONDS.sleep(1); 
} catch(InterruptedExceptione) { 
e.printStackTrace(); 
} 
return null; 
} 
@Override 
protected void onProgressUpdate(Integer... values) { 
super.onProgressUpdate(values); 
tv.setText("обработано " + values[0] + " параметров"); 
} 

*Задание 3.*  Проверьте пример создания простой асинхронной задачи 

public class MainActivity extends Activity{ 
MyAsyncTask at; 
TextView tv; 
public void onCreate(Bundle savedInstance State) { 
super.onCreate(savedInstanceState); 
setContentView(R.layout.main); 
tv= (TextView) findViewById(R.id.tv); 
MyAsyncTask at = new MyAsyncTask(); 
at.execute(); 
} 
} 

*Задание 4.* На основании изученных примеров разработать приложение с подключение API. 

## Описание приложения
Мой выбор пал на разработку мобильного приложения погода с подключение API с сайта OpenWeather https://openweathermap.org/ 
Приложение состоит из одного Activity. Оно очень простое и без оформлений (пока).
В него входт: 1) Поле "Введите название города",где надо ввести название города на руссском языке или английском,но ВАЖНО максимально правильно и точно.
2) Кнопка "Получить погоду"
3) Поле с выводом погоды в каком-то городе

## Как работает это приложение


https://github.com/user-attachments/assets/e76c144b-13b4-4e5b-9300-67d86c5fa37a

