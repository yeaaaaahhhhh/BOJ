
#include<iostream>

using namespace std;

int main(int argc, char** argv)
{
	int N;
	long long int X;
	cin >> N >> X;
	char* res = new char[N+1];
	res[N] = '\0';
	X -= N;
	if (X < 0)
	{
		cout << "!";
		return 0;
	}
	for (int i = 0; i < N; i++)
	{
		if (X >= 25)
		{
			res[N - i - 1] = 'A' + 25;
			X -= 25;
		}
		else
		{
			res[N - i - 1] = 'A' + (X % 25);
			X = 0;
		}
	}
	if (X > 0)
	{
		cout << "!";
		return 0;
	}
	cout << res;
	return 0;
}