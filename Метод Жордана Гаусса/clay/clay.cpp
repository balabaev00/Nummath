
#include "pch.h"
#include <iostream>
#include <locale.h>
#include <vector>

using namespace std;

const unsigned N = 30;

void print_arr(float arr[N][N+1],unsigned n)
{
	for (unsigned i = 0; i < n; i++)
	{
		for (unsigned j = 0; j < n + 1; j++)
		{
			cout.precision(3);
			cout << arr[i][j] << "		 ";
		}
		cout << endl;
	}

}


int main()
{
	setlocale(LC_ALL, "Rus");
	/*Описание массива*/
	float arr[N][N + 1] = { { -0.74,0.47,-0.15,-0.3,0.81,-0.97 }, { 0.01,-0.65,-0.64,0.58,-0.04,-0.86 }, { -0.33,0.01,-0.61,-0.95,0.19,-0.82 }, 
	{ -0.96,-0.42,-0.03,0.68,-0.71,0.99 } , {0.07,0.73,-0.97,0.84,-0.35,-0.11} };
	/*Описание корней системы*/
	float x[N];
	float b[N];
	/*Описание порядка корней*/
	int order[N];
	/*Описание количества уравнений*/
	unsigned n = 5;
	/*Используемые переменные*/
	int i, j, k = 0;
	float buf;
	/*Вывод матрицы*/
	cout << "Начальная матрица" << endl;
	print_arr(arr,n);
	/*Расположение корней по порядку*/
	for (unsigned i = 0; i < n + 1; i++)
		order[i] = i;
	// Нули под нижней диагональю
	for (k = 0; k < n; k++)
	{ 
		for (j = n; j >= k; j--)
			arr[k][j] /= arr[k][k];
		for (i = k + 1; i < n; i++)
			for (j = n; j >= k; j--)
				arr[i][j] -= arr[k][j] * arr[i][k];
	}
	/*Вывод матрицы после прямого хода*/
	cout << "			Промежуточный вывод матрицы №1" << endl;
	print_arr(arr, n);
	//Обратный ход 
	/*for (i = 0; i < n; i++)
		x[i] = arr[i][n];
	for (i = n - 2; i >= 0; i--)
		for (j = i + 1; j < n; j++)
			x[i] -= x[j] * arr[i][j];*/
	
	


	
	float del;
	del = arr[3][4];
	arr[3][5] -= arr[4][5] * del;
	arr[3][4] -= arr[4][4] * del;

	del = arr[2][4];
	arr[2][5] -= arr[4][5] * del;
	arr[2][4] -= arr[4][4] * del;

	del = arr[2][3];
	arr[2][5] -= arr[3][5] * del;
	arr[2][5] -= arr[3][4] * del;
	arr[2][3] -= arr[3][3] * del;

	del = arr[1][4];
	arr[1][5] -= arr[4][5] * del;
	arr[1][4] -= arr[4][4] * del;

	del = arr[1][3];
	arr[1][5] -= arr[3][5] * del;
	arr[1][4] -= arr[3][4] * del;
	arr[1][3] -= arr[3][3] * del;

	del = arr[1][2];
	arr[1][5] -= arr[2][5] * del;
	arr[1][4] -= arr[2][4] * del;
	arr[1][3] -= arr[2][3] * del;
	arr[1][2] -= arr[2][2] * del;

	del = arr[0][4];
	arr[0][5] -= arr[4][5] * del;
	arr[0][4] -= arr[4][4] * del;

	del = arr[0][3];
	arr[0][5] -= arr[3][5] * del;
	arr[0][4] -= arr[3][4] * del;
	arr[0][3] -= arr[3][3] * del;
	

	del = arr[0][2];
	arr[0][5] -= arr[2][5] * del;
	arr[0][4] -= arr[2][4] * del;
	arr[0][3] -= arr[2][3] * del;
	arr[0][2] -= arr[2][2] * del;

	del = arr[0][1];
	arr[0][5] -= arr[1][5] * del;
	arr[0][4] -= arr[1][4] * del;
	arr[0][3] -= arr[1][3] * del;
	arr[0][2] -= arr[1][2] * del;
	arr[0][1] -= arr[1][1] * del;
	
	
	x[n - 1] = arr[n - 1][n] / arr[n - 1][n - 1];
	for (i = n - 2; i >= 0; i--) {
		buf = 0;
		for (j = i + 1; j < n; j++)
		{
			buf += arr[i][j] * x[j];
			arr[i][j] = buf;
		}
		x[i] = (arr[i][n] - buf) / arr[i][i];
	}

	cout << "			Промежуточный вывод матрицы №2" << endl;
	print_arr(arr, n);

		

		cout << "Ответ" << endl;
	//Вывод результата на экран 
	for (i = 0; i < n; i++)
		for (j = 0; j < n; j++)
			if (i == order[j])
			{ 
				//Расставляем корни по порядку
				cout << x[j] << endl;
				break;
			}
	system("pause");
}

