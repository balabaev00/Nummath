

#include "pch.h"
#include <iostream>
using namespace std;

int main()
{
	setlocale(LC_ALL, "Rus");
	const float x = -0.2;
	const int n = 6;
	float arr_x[n] = { -1.2, -0.9, 0.7, 1.1, 1.7, 2.9 };
	float arr_y[n] = { 3.38688, -1.50579, 16.99677, 25.85121, 28.70127, 0.55419 };
	float p_x;
	float chicl, znam;
	p_x = 0;
	for (unsigned k = 0; k < n; k++)
	{
		chicl = 1;
		for (unsigned i = 0; i < n; i++)
			if (i != k)
			{
				chicl = chicl * (x - arr_x[i]);
			}
		znam = 1;
		for (unsigned j = 0; j < n; j++)
			if (j != k)
				znam = znam * (arr_x[k] - arr_x[j]);
		p_x += arr_y[k] * chicl / znam;
	}
	cout << "Вывод лагранжа : " << p_x << "\n";
	system("pause");
}
